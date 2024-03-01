package com.ra.module5version2.service.User;

import com.ra.module5version2.model.dto.request.UserRegister;
import com.ra.module5version2.model.entity.ERoles;
import com.ra.module5version2.model.entity.Role;
import com.ra.module5version2.model.entity.User;
import com.ra.module5version2.reporsitory.UserRepository;
import com.ra.module5version2.service.User.Role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleService roleService;

    @Override
    public User handleRegister(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("username is exists");
        }

        Set<Role> roles = new HashSet<>();
        roles.add(roleService.findByRoleName(ERoles.ROLE_USER));

        User users = User.builder()
                .fullName(user.getFullName())
                .username(user.getUsername())
                .password(passwordEncoder.encode(user.getPassword()))
                .email(user.getEmail())
                .avatar(user.getAvatar())
                .phone(user.getPhone())
                .address(user.getAddress())
                .created(new Date(new java.util.Date().getTime()))
                .status(true)
                .roles(roles)
                .build();
        userRepository.save(users);
        return users;
    }

    @Override
    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean delete(Long id) {
        try{
            this.userRepository.delete(findById(id));
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public User save(User users) {
        return userRepository.save(users);
    }

    @Override
    public User updateAcc(UserRegister userRegister, Long id) {
        if (userRepository.existsByUsername(userRegister.getUsername())) {
            throw new RuntimeException("username is exists");
        }

        User userOld = findById(id);

        Set<Role> roles = userOld.getRoles();

        User users = User.builder()
                .id(id)
                .fullName(userRegister.getFullName())
                .username(userRegister.getUsername())
                .password(userOld.getPassword())
                .email(userRegister.getEmail())
                .avatar(userRegister.getAvatar())
                .phone(userRegister.getPhone())
                .address(userRegister.getAddress())
                .created(userOld.getCreated())
                .updated(new Date(new java.util.Date().getTime()))
                .status(true)
                .roles(roles)
                .build();
        return userRepository.save(users);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> SearchByFullName(String keyword) {
        return userRepository.searchAllByUAndFullName(keyword);
    }
}
