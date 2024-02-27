package com.ra.module5version2.model.dto.respone;

import java.util.Set;

public class JwtResponse {
    private String accessToken;
    private final String type = "Bearer";
    private String fullName;
    private String username;
    private Boolean status;
    private Set<String> roles;
}
