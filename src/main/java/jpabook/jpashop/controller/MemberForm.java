package jpabook.jpashop.controller;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
@Getter @Setter
public class MemberForm {

	@NotBlank(message = "회원 이름은 필수 입니다")
	private String name;

	@NotBlank(message = "비밀번호는 필수 입니다")
	private String passwd;

	private String city;
	private String street;
	private String zipcode;
}
