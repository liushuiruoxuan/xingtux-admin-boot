package com.xt.business.sys.service;

import com.xt.business.sys.domain.dto.AuthDTO;
import com.xt.business.sys.domain.dto.LoginDTO;

public interface IAuthService {
    String login(LoginDTO loginDTO);
}
