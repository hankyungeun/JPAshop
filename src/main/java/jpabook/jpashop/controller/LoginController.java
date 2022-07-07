package jpabook.jpashop.controller;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.service.LoginService;
import jpabook.jpashop.exception.SessionConstants;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@Controller
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/login")
    public String loginForm(@ModelAttribute LoginForm loginForm) {

        return "login/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute @Validated LoginForm loginForm,
        BindingResult bindingResult,
        @RequestParam(defaultValue = "/") String redirectURL,
        HttpServletRequest request) {

        if (bindingResult.hasErrors()) {
            return "login/login";
        }

        Member loginMember = loginService.login(loginForm.getName(), loginForm.getName());

        if (loginMember == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "login/login";
        }

        // 로그인 성공 처리
        HttpSession session = request.getSession(); // 세션이 있으면 있는 세션 반환, 없으면 신규 세션을 생성하여 반환
        session.setAttribute(SessionConstants.LOGIN_MEMBER, loginMember); // 세션에 로그인 회원 정보 보관

        return "redirect:" + redirectURL;
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        return "redirect:/";
    }

}
