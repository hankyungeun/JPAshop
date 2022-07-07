//package jpabook.jpashop.service;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import javax.persistence.EntityManager;
//import javax.persistence.OrderColumn;
//import jpabook.jpashop.domain.Address;
//import jpabook.jpashop.domain.Member;
//import jpabook.jpashop.domain.Order;
//import jpabook.jpashop.domain.OrderStatus;
//import jpabook.jpashop.domain.item.Book;
//import jpabook.jpashop.repository.OrderRepository;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.mockito.BDDMockito.Then;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.util.Assert;
//
//@SpringBootTest
//@Transactional
//public class OrderServiceTest {
//
//	@Autowired
//	EntityManager em;
//	@Autowired
//	OrderService orderService;
//	@Autowired OrderRepository orderRepository;
//
//	@Test
//	public void 상품주문() throws Exception{
//		//given
//		Member member = new Member();
//		member.setName("회원1");
//		member.setAddress(new Address("서울", "강가", "123-123"));
//		em.persist(member);
//
//		Book book = new Book();
//		book.setName("시골 JPA");
//		book.setPrice(10000);
//		book.setStockQuantity(10);
//		em.persist(book);
//		int orderCount = 2;
//
//
//		//when
//		Long orderId = orderService.order(member.getId(), book.getId(), orderCount);
//
//		//then
//		Order getOrder = orderRepository.findOne(orderId);
//
//		assertEquals(OrderStatus.ORDER, getOrder.getStatus());
//		assertEquals(1, getOrder.getOrderItems().size());
//		assertEquals(10000 * orderCount, getOrder.getTotalPrice());
//		assertEquals( 8, book.getStockQuantity());
//
//	}
//
//
//	@Test
//	public void 상품주문_재고수량초과() throws Exception{
//		//given
//
//
//		//when
//
//		//then
//
//	}
//
//	@Test
//	public void 주문취소() throws Exception{
//		//given
//
//		//when
//
//		//then
//	}
//
//
//}
