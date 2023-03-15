package com.sk.market.order.adapter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.sk.market.order.domain.OrderStatus;

import lombok.*;

@Data
@Setter(value = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
@Table(name = "ORDERS")
@Entity
public class OrderEntity {
	
	@Id
	@Column(name = "ORDER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;
	
	@Column(name = "TOTAL_PRICE")
	private BigDecimal totalPrice;

	@Enumerated(EnumType.STRING)
	@Column(name = "ORDER_STATUS")
	private OrderStatus orderStatus;

	@ElementCollection
	@CollectionTable(name = "ORDER_ITEM", joinColumns = @JoinColumn(name = "order_item_id"))
	private List<OrderItemEntity> orderItems = new ArrayList<>();

}