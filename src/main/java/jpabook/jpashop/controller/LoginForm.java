package jpabook.jpashop.controller;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginForm {

	@NotBlank
	private String name;

	@NotBlank
	private String passwd;
}
