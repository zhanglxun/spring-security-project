package com.sense.form.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // 配置关闭csrf机制，
        http.csrf(csrf -> csrf.disable());
        // 配置请求拦截方式
        http.authorizeHttpRequests(auth->auth
                .requestMatchers("/login").permitAll()
                .anyRequest()
                .authenticated()
        );
        //.httpBasic(Customizer.withDefaults())

        http.formLogin(form -> form.loginPage("/login") // 跳转到自定的登录页面
                .loginProcessingUrl("/login") // 处理前端的请求，与form表单的action一致
                .usernameParameter("username") // 用户名
                .passwordParameter("password") // 密码
                .defaultSuccessUrl("/index") // 请求到index接口上
        );

        return http.build();
    }
}
