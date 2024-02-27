package com.ra.module5version2.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long id;
    @Column(name = "role_name")
    @Enumerated(EnumType.STRING)
    private ERoles roleName;
//    @OneToMany(mappedBy = "role")
//    private Set<UserRole> roleUser;
}
