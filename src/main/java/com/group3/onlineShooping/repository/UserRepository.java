package com.group3.onlineShooping.repository;

import com.group3.onlineShooping.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    //User findByUserName(String userName);
    Optional<User> findByUsername(String username);
}
