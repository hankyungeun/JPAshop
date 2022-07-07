package jpabook.jpashop.repository;

import java.util.Optional;
import jpabook.jpashop.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LoginRepository extends JpaRepository<Member, String>, JpaSpecificationExecutor<Member> {
	Optional<Member> findByName(String name);


}
