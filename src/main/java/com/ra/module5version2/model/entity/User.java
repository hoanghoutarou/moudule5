package com.ra.module5version2.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "username", unique = true, length = 100)
    @JsonFormat(pattern = "^[a-zA-Z0-9]+$")
    private String username;
    @Column(name = "email")
    private String email;

    @Column(name = "fullname", nullable = false, length = 100)
    private String fullName;
    @Column(name = "status")
    private boolean status;

    @Column(nullable = false)
    private String password;

    private String avatar;

    @Column(unique = true, length = 15)
    @JsonFormat(pattern = "^0[1-9]\\d{8}$")
    private String phone;

    @Column(nullable = false)
    private String address;

    @Column(name = "created_at")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date created;

    @Column(name = "updated_at")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date updated;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();
}
