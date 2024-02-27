package com.ra.module5version2.reporsitory;

import com.ra.module5version2.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
    @Query("SELECT u.fullName from User u WHERE u.fullName like %?1% ")
    List<User> searchAllByUAndFullName(String keyword);
    boolean existsByUsername(String username);
}
