package com.group3.onlineShooping.service;

import com.group3.onlineShooping.domain.Item;


import java.util.List;

public interface ItemService {
    public List<Item> findAll();
    public Item save(Item item );
    public Item find(Long id);
    public Item put(Item item);
    public void delete(Item item);

}
