package com.group3.onlineShooping.repository;

import com.group3.onlineShooping.domain.Admin;
import com.group3.onlineShooping.domain.Buyer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AdminRepository extends CrudRepository<Admin, Long> {

    Admin findByEmail(String email);

    @Query(value = "select b from Admin b left join fetch b.user")
    List<Admin> getAllAdmin();

}