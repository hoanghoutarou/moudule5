package com.ra.module5version2.service.User;

import com.ra.module5version2.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User handleRegister(User user);
    Page<User> getAll(Pageable pageable);
    User findById(Long id);
    void delete(Long id);
    User save(User users);
//    User updateAcc(UserRegister userRegister, Long id);
    Optional<User> findByUsername(String username);
    List<User> SearchByFullName(String keyword);
}
