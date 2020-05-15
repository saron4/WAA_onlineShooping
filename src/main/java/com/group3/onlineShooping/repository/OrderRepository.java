
package com.group3.onlineShooping.repository;

import com.group3.onlineShooping.domain.Item;
import com.group3.onlineShooping.domain.Order;
import com.group3.onlineShooping.domain.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
    @Query(value = "SELECT o FROM  Orders o Join o.cartItem c join c.item i join i.product p WHERE p.seller.email = :username")
    List<Order> getAllBySeller(String username);

    @Query(value = "SELECT o FROM  Orders o  WHERE  o.cartItem.buyer.email = :username")
    List<Order> getAllByBuyer(String username);

}
