package com.xt.common.util;

import ch.qos.logback.core.util.TimeUtil;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.google.common.collect.Maps;
import com.xt.business.sys.domain.dto.AuthDTO;
import com.xt.business.sys.domain.dto.LoginDTO;
import com.xt.business.sys.domain.entity.User;
import com.xt.common.constants.CacheConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.TimeoutUtils;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author hongxuanchai
 */
@Component
@Slf4j
public class JwtUtils {

    @Resource
    private RedisCacheUtil redisCacheUtil;
    @Resource
    private RedisTemplate redisTemplate;
    private static final String SECRET_KEY = "asdfasdfasdfadf2werweraw";
    /**
     * 创建token
     */
    public  String createToken(AuthDTO authDTO) {
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        authDTO.setToken(token);
        authDTO.setLoginTime(System.currentTimeMillis());
        HashMap<String, Object> claims = Maps.newHashMap();
        claims.put("token",token);
        log.info("push token:{}",token);
        redisCacheUtil.setCacheObject(CacheConstants.LOGIN_USER_KEY + token,authDTO, 30, TimeUnit.MINUTES);
        return  Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512,SECRET_KEY).compact();
    }

    /**
     * 解析token
     * @param token token
     * @return claims
     */
    public Claims parseToken(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    public  Object getLoginUser(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        if (StrUtil.isNotBlank(authorization)){
            Claims claims = parseToken(authorization);
            log.info("getLoginUser claims:{}",claims);
            String token = (String) claims.get("token");
            AuthDTO authDTO = redisCacheUtil.getCacheObject(CacheConstants.LOGIN_USER_KEY + token);
            long between = DateUtil.between(DateUtil.date(authDTO.getLoginTime()), DateUtil.date(), DateUnit.MINUTE);
            if (between >= 20){
                refreshToken(authDTO);
            }
            log.info("getLoginUser refreshToken authDTO:{}",authDTO);
            return authDTO;
        }

        return null;
    }

    public void refreshToken(AuthDTO authDTO){
        redisCacheUtil.setCacheObject(CacheConstants.LOGIN_USER_KEY + authDTO.getToken(),authDTO,30,TimeUnit.MINUTES);
    }
}
