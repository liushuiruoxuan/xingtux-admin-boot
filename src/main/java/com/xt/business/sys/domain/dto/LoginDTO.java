package com.xt.business.sys.domain.dto;

import lombok.Data;

@Data
public class LoginDTO {
    private String username;
    private String password;
    private Integer rememberMe;
}
