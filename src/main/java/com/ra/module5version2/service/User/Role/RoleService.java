package com.ra.module5version2.service.User.Role;

import com.ra.module5version2.model.entity.ERoles;
import com.ra.module5version2.model.entity.Role;

import java.util.List;

public interface RoleService {
    Role findByRoleName(ERoles name);
    List<Role> getAll();
}
