package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginService {

    private final LoginRepository loginRepository;

    /**
     * @return null이면 로그인 실패
     */
    public Member login(String name, String passwd) {

        return loginRepository.findByName(name)
                .filter(m -> m.getPasswd().equals(passwd))
                .orElse(null);
    }
}
