package jpabook.jpashop.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.exception.SessionConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SimpleController {
	@GetMapping("/simple")
	public String testingSimple(HttpServletRequest req) {
		HttpSession session = req.getSession();

		Member member = (Member) session.getAttribute(SessionConstants.LOGIN_MEMBER);
		//System.out.println(member);
		return member.getName();
	}
}
