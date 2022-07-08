package jpabook.jpashop.controller;

import javax.servlet.http.HttpServletRequest;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.exception.SessionConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class HomeController {

	@RequestMapping("/")
	public String home(HttpServletRequest request, Model model) {
		Member member = (Member) request.getSession().getAttribute(SessionConstants.LOGIN_MEMBER);
		if (member != null) {
			model.addAttribute("member", member);
		}

		log.info("home controller");
		return "home";
	}
}
