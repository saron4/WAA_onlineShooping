package com.group3.onlineShooping.service;

import com.group3.onlineShooping.domain.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    public List<Role> findAll();
    public Role save(Role role);
    public Optional<Role> find(Long id);
    public Role findByRoleName(String roleName);
    public Role put(Role role);
}
