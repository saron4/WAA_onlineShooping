package com.group3.onlineShooping.serviceimpl;

import com.group3.onlineShooping.domain.User;
import com.group3.onlineShooping.repository.UserRepository;
import com.group3.onlineShooping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }


    @Override
    public User save(User user ) {
        return userRepository.save(user);
    }

    @Override
    public User find(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
    @Override
    public User put(User user) {
        return userRepository.save(user);
    }

}
