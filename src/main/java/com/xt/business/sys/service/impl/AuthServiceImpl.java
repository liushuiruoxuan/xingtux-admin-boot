package com.xt.business.sys.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.xt.business.sys.domain.dto.AuthDTO;
import com.xt.business.sys.domain.dto.LoginDTO;
import com.xt.business.sys.service.IAuthService;
import com.xt.common.exception.BusinessException;
import com.xt.common.util.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuthServiceImpl implements IAuthService {

    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    public AuthServiceImpl(JwtUtils jwtUtils, AuthenticationManager authenticationManager) {
        this.jwtUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public String login(LoginDTO loginDTO) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);

        AuthDTO authDTO = (AuthDTO)authenticate.getPrincipal();
        if (ObjectUtil.isNull(authDTO)){
            throw new BusinessException(HttpStatus.UNAUTHORIZED.value(),"认证失败！");
        }
        String token = jwtUtils.createToken(authDTO);
        log.info("token:{}",token);
        return token;
    }
}
