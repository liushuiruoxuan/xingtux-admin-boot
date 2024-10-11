package com.xt.common.filter;

import cn.hutool.core.util.ObjectUtil;
import com.xt.business.sys.domain.dto.AuthDTO;
import com.xt.common.util.JwtUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * @author hongxuanchai
 */
@Component
@Slf4j
public class JwtAuthticationFilter extends OncePerRequestFilter {
    private final JwtUtils jwtUtils;

    public JwtAuthticationFilter(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //获取登录用户
        AuthDTO authDTO = (AuthDTO)jwtUtils.getLoginUser(request);
        //判断是否登录成功
        if (ObjectUtil.isNotNull(authDTO)){
            //鉴权。跳转的时候性需要访问index页面
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(authDTO,null,authDTO.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        //放行。
        filterChain.doFilter(request,response);
    }
}
