package jpabook.jpashop.controller;
import java.util.ArrayList;
import java.util.List;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.service.LoginService;
import jpabook.jpashop.exception.SessionConstants;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "login/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute @Validated LoginForm loginForm,
        BindingResult bindingResult,
        HttpServletRequest request) {

        if (bindingResult.hasErrors()) {
            return "login/login";
        }

        Member loginMember = loginService.login(loginForm.getName(), loginForm.getPasswd());

        if (loginMember == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "login/login";
        }

        // 로그인 성공 처리
        HttpSession session = request.getSession();
        session.setAttribute(SessionConstants.LOGIN_MEMBER, loginMember); // 세션에 로그인 회원 정보 보관

        return "/hello";
    }
    @GetMapping("/logout")      //세션날림
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute(SessionConstants.LOGIN_MEMBER);

        return "redirect:/";
    }
}
