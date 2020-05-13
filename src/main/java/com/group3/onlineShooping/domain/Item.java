package com.group3.onlineShooping.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Item {
    //created means it is inside shopping cart
    public enum ItemStatus {
        Created,
        ORDERED,
        SHIPPED,
        TRANSIT,
        DELIVERED,
        CANCELD
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal itemPrice;
    private Long quantity;
    @Enumerated(EnumType.STRING)
    private ItemStatus itemStatus = ItemStatus.Created;

    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cart_ID")
    private CartItem cartItem;

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", itemPrice=" + itemPrice +
                ", quantity=" + quantity +
                ", itemStatus=" + itemStatus +
                '}';
    }
}
