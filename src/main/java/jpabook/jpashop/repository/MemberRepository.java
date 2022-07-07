package jpabook.jpashop.repository;

import java.util.Optional;
import jpabook.jpashop.domain.Member;
import javax.persistence.*;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

	private final EntityManager em;

	public void save(Member member){
		em.persist(member);
	}

	public Member findOne(Long id){
		return em.find(Member.class, id);
	}

	public List<Member> findAll(){
		return em.createQuery("select m from Member m", Member.class)
			.getResultList();
	}


	public List<Member> findByName(String name){				//이름에 의한 회원조회
		return em.createQuery("select m from Member m where m.name = :name", Member.class)
			.setParameter("name", name)
			.getResultList();
	}
}
