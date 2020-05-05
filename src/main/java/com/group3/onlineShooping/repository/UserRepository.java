package com.group3.onlineShooping.repository;

import com.group3.onlineShooping.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUserName(String userName);
}
