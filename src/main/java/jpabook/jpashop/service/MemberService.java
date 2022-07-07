package jpabook.jpashop.service;

import com.sun.javafx.logging.PulseLogger;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;

//	@Autowired
//	public MemberService(MemberRepository memberRepository) {
//		this.memberRepository = memberRepository;
//	}

	//회원가입
	@Transactional
	public Long join(Member member){
		validateDuplicateMember(member);	//중복 회원 검증
		memberRepository.save(member);
		return member.getId();				//항상 값이 있다는 보장이된다
	}

	private void validateDuplicateMember(Member member) {
		List<Member> findMembers =
			memberRepository.findByName(member.getName());
		if (!findMembers.isEmpty()) {
			throw new IllegalStateException("이미 존재하는 회원입니다.");
		}
	}

	//회원 전체 조회
	@Transactional(readOnly = true)
	public List<Member> findMembers(){
		return memberRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Member findOne(Long memberId){
		return memberRepository.findOne(memberId);
	}
}
