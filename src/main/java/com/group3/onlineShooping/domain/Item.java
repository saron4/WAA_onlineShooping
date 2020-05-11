package com.group3.onlineShooping.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Item {
    //created means it is inside shopping cart
    public enum ItemStatus {
        Created, Processing, Paid, Finished, Cancelled
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal itemPrice;
    private Long quantity;
    @Enumerated(EnumType.STRING)
    private ItemStatus itemStatus = ItemStatus.Created;
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

}
