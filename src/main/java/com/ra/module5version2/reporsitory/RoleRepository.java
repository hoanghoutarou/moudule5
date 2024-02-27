package com.ra.module5version2.reporsitory;

import com.ra.module5version2.model.entity.ERoles;
import com.ra.module5version2.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByRoleName(ERoles name);
}
