package com.ra.module5version2.security.UserDetail;

import com.ra.module5version2.model.entity.User;
import com.ra.module5version2.reporsitory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUsers = userRepository.findByUsername(username);
        if(optionalUsers.isPresent()) {
            User users = optionalUsers.get();
            return UserPrincipal.builder()
                    .users(users)
                    .authorities(users.getRoles()
                            .stream()
                            .map(item -> new SimpleGrantedAuthority(item.getRoleName().name()))
                            .collect(Collectors.toSet()))
                    .build();
        }
        throw new RuntimeException("role not found");
    }
}
