package com.xt.business.sys.domain.dto;

import cn.hutool.core.util.ObjectUtil;
import com.google.common.collect.Lists;
import com.xt.business.sys.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.ObjectUtils;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hongxuanchai
 */

@Data
public class AuthDTO implements UserDetails {

    private Long id;

    private String token;

    private Long loginTime;
    private User user = new User();
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<String> perms = user.getPerms();
        //判断返回数据
        if (ObjectUtil.isNotEmpty(perms)){
            return perms.stream().filter(ObjectUtil::isNotEmpty).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        }
        return Lists.newArrayList();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return user.getStatus() == 0;
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.getStatus() == 0;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return user.getStatus() == 0;
    }

    @Override
    public boolean isEnabled() {
        return user.getStatus() == 0;
    }
}
