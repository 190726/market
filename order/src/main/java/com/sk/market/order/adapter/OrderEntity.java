package com.sk.market.order.adapter;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sk.market.order.domain.OrderStatus;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter(value = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
@AllArgsConstructor
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
}