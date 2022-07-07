package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import sun.security.util.Password;

@Entity
@Getter @Setter
public class Member {

	@Id @GeneratedValue
	@Column(name="member_id")
	private Long id;

	private String name;

	private String passwd;

	@Embedded
	private Address address;

	@OneToMany(mappedBy = "member")
	private List<Order> orders = new ArrayList<>();



}
