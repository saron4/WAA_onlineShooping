package com.group3.onlineShooping.serviceimpl;

import com.group3.onlineShooping.domain.Admin;
import com.group3.onlineShooping.domain.Buyer;
import com.group3.onlineShooping.repository.AdminRepository;
import com.group3.onlineShooping.repository.BuyerRepository;
import com.group3.onlineShooping.service.AdminService;
import com.group3.onlineShooping.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    private AdminRepository adminRepository;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public List<Admin> findAll() {
        return (List<Admin>) adminRepository.findAll();
    }

    @Override
    public List<Admin> getAllAdmin() {
        return adminRepository.getAllAdmin();
    }

    @Override
    public Admin save(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Admin find(Long id) {
        return adminRepository.findById(id).get();
    }

    @Override
    public Admin findByEmail(String email) {
        return adminRepository.findByEmail(email);
    }

    @Override
    public Admin put(Admin admin) {
        return adminRepository.save(admin);
    }

}