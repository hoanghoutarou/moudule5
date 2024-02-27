package com.ra.module5version2.service.User.Role;

import com.ra.module5version2.model.entity.ERoles;
import com.ra.module5version2.model.entity.Role;
import com.ra.module5version2.reporsitory.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public Role findByRoleName(ERoles name) {
        Role role = roleRepository.findByRoleName(name).orElseThrow(() -> new RuntimeException("role not found"));
        return role;
    }

    @Override
    public List<Role> getAll() {
        return null;
    }
}
