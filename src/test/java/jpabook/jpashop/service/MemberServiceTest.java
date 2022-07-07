package jpabook.jpashop.service;


import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.*;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
@Transactional
public class MemberServiceTest {

	@Autowired MemberService memberService;
	@Autowired MemberRepository memberRepository;
	@Autowired EntityManager em;

	@Test
	public void 회원가입() throws Exception {
		//given
		Member member = new Member();
		member.setName("kim");

		//when
		Long savedId = memberService.join(member);

		//then
		assertEquals(member, memberRepository.findOne(savedId));
	}

//	@Test(expected = IllegalStateException.class)
//	public void 중복_회원_예외() throws Exception {
//
//		Member member1 = new Member();
//		member1.setName("kim");
//
//		Member member2 = new Member();
//		member2.setName("kim");
//
//
//		memberService.join(member1);
//		memberService.join(member2);
//
//		fail("예외가 발생해야 한다.");
//	}
}
