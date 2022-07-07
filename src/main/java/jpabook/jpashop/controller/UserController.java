package jpabook.jpashop.controller;
import jpabook.jpashop.repository.LoginRepository;
import jpabook.jpashop.domain.Member;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final LoginRepository loginRepository;

    @GetMapping
    public List<Member> findAllUsers() {
        return loginRepository.findAll();
    }
}
