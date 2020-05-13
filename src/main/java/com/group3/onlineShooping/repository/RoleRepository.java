package com.group3.onlineShooping.repository;

import com.group3.onlineShooping.domain.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RoleRepository extends CrudRepository<Role,Long> {
     Role findByRoleName(String roleName);
     List<Role> findAll();
}
