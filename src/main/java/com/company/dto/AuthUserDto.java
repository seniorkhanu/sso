package com.company.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.company.entity.AuthUser}
 */
@Data
public class AuthUserDto implements Serializable {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String personalIdentificationNumber;
    private String passport;
    private String inn;
    private LocalDateTime createdAt;
}