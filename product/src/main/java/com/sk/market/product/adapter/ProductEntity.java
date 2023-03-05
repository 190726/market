package com.sk.market.product.adapter;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import com.sk.market.product.domain.Category;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(value = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@Table(name = "PRODUCTS")
@Entity
public class ProductEntity {
	
	@Id
	@Column(columnDefinition = "uuid")
	private UUID id;
	
	private String name;
	
	private BigDecimal price;
	
	@Enumerated(EnumType.STRING)
	private Category category;
}
