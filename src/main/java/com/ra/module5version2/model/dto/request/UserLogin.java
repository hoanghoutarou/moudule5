package com.ra.module5version2.model.dto.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserLogin {
    private String username;
    private String password;
}
