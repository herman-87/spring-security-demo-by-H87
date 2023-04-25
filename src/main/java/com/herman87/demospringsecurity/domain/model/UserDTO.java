package com.herman87.demospringsecurity.domain.model;

import lombok.Getter;

@Getter
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private String verifyPassword;
}
