package com.xt.business.sys.controller;


import com.xt.business.sys.domain.dto.LoginDTO;
import com.xt.business.sys.service.IAuthService;
import com.xt.common.ResponseResult;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


/**
 * @author hongxuanchai
 */
@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {

    @Resource
    private IAuthService authService;

    @Resource
    private PasswordEncoder passwordEncoder;
    @PostMapping("/sys")
    public ResponseResult<String> login(@RequestBody LoginDTO loginDTO){
        log.info("login:{}",loginDTO);
        String token = authService.login(loginDTO);
        return ResponseResult.success(null,token);
    }

    @GetMapping("")
    public String aa() {
        return passwordEncoder.encode("123456");
    }
}
