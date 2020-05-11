package com.group3.onlineShooping.repository;

import com.group3.onlineShooping.domain.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
           // Item findItemByCart();
}
