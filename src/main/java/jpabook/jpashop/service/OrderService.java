package jpabook.jpashop.service;

import java.util.List;
import jpabook.jpashop.domain.Delivery;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import jpabook.jpashop.repository.MemberRepository;
import jpabook.jpashop.repository.OrderRepository;
import jpabook.jpashop.repository.OrderSearch;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

	private final OrderRepository orderRepository;
	private final ItemRepository itemRepository;
	private final MemberRepository memberRepository;

	//주문
	@Transactional
	public Long order(Long memberId, Long itemId, int count) {

		//앤티티 조회
		Member member = memberRepository.findOne(memberId);
		Item item = itemRepository.findOne(itemId);

		//배송정보 생성T
		Delivery delivery = new Delivery();
		delivery.setAddress(member.getAddress());

		//주문상품 생성
		OrderItem orderItem = OrderItem.creatOrderItem(item, item.getPrice(), count);

		//주문생성
		Order order  = Order.createOrder(member, delivery, orderItem);

		//주문저장
		orderRepository.save(order);

		return order.getId();
	}


	//취소
	@Transactional
	public void cancelOrder(Long orderId){
		//주문 앤티티조회
		Order order = orderRepository.findOne(orderId);
		//주문취소
		order.cancel();

	}
	//검색
	public List<Order> findOrders(OrderSearch orderSearch){
		return orderRepository.findAllByCriteria(orderSearch);
	}
}
