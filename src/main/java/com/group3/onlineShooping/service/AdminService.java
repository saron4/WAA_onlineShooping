package com.group3.onlineShooping.service;

import com.group3.onlineShooping.domain.Admin;
import com.group3.onlineShooping.domain.Buyer;

import java.util.List;


public interface AdminService {

    public List<Admin> findAll();

    public List<Admin> getAllAdmin();

    public Admin save(Admin buyer);

    public Admin find(Long id);

    public Admin findByEmail(String email);

    public Admin put(Admin buyer);
}