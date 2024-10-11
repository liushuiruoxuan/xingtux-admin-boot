package com.xt.common.config.security;


import com.google.common.collect.Lists;
import com.xt.business.sys.service.impl.UserDetailServiceImpl;
import com.xt.common.filter.JwtAuthticationFilter;
import io.swagger.models.HttpMethod;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


/**
 * @author hongxuanchai
 */


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Resource
    private UserDetailsService userDetailsService;

    @Resource
    private JwtAuthticationFilter jwtAuthticationFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // 禁用csrf
        http.csrf(AbstractHttpConfigurer::disable);
        // 配置拦截策略
        http.authorizeHttpRequests(auth->auth.requestMatchers("/**").permitAll().anyRequest().authenticated());
        // 开启form认证
        http.formLogin(Customizer.withDefaults());
        // 配置跨域
        http.cors(cors -> cors.configurationSource(corsConfigurationSource()));
        http.addFilterBefore(jwtAuthticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setUserDetailsService(userDetailsService);
        return new ProviderManager(authenticationProvider);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return  new BCryptPasswordEncoder();
    }
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOrigins(Lists.newArrayList("*"));
        corsConfiguration.setAllowedMethods(Lists.newArrayList("*"));
        corsConfiguration.setAllowedHeaders(Lists.newArrayList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }
}
