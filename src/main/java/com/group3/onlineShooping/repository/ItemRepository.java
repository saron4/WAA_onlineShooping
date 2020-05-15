package com.group3.onlineShooping.repository;

import com.group3.onlineShooping.domain.Item;
import com.group3.onlineShooping.domain.Product;
import com.group3.onlineShooping.domain.Seller;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
     @Modifying
    @Query("DELETE FROM Item i WHERE i.cartItem.cartId = ?1")
    void deleteItemByCartItem(Long  cartID);

    @Query(value = "SELECT i.product FROM  Item i JOIN i.product  WHERE  i.itemStatus= :itemStatus AND i.product=:product")
    List<Product> findAllByItemStatusAndProduct(Item.ItemStatus itemStatus, Product product);

    @Modifying
    @Query("update Item i set i.itemStatus = ?1 where i.cartItem.cartId = ?2")
    void setItemStatus(Item.ItemStatus  itemStatus, Long cartID );


}
