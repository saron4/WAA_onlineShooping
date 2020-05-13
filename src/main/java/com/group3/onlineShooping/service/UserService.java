package com.group3.onlineShooping.service;


import com.group3.onlineShooping.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<User> findAll();
    public User save(User user);
    public User find(Long id);
    public Optional<User> findByUserName(String userName);
    public User put(User User);
}
