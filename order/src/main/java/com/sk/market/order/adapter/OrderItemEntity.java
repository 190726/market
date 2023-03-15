package com.sk.market.order.adapter;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Setter(value = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Embeddable
public class OrderItemEntity {

    @Column(name = "PRODUCT_ID")
    private UUID productId;
    @Column(name = "PRODUCT_NM")
    private String productNm;
    private Long amount;
    private BigDecimal price;
}
