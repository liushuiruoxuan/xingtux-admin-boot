package com.xt.common.util;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.xt.business.sys.domain.dto.AuthDTO;
import com.xt.common.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {

    public  static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * h获取用户
     * @return
     */
    public static AuthDTO getAuthUser() {
        return (AuthDTO) getAuthentication().getPrincipal();
    }

    public static Long getUserId() {
        Long id = getAuthUser().getId();
        if (ObjectUtil.isNull(id)){
            throw new BusinessException(HttpStatus.FORBIDDEN.value(), "用户不存在");
        }
        return id;
    }

    public static String getUserName() {
        String username = getAuthUser().getUsername();
        if (StrUtil.isBlank(username)){
            throw new BusinessException(HttpStatus.FORBIDDEN.value(), "用户不存在");
        }
        return username;
    }
}
