package com.sense.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // 配置关闭csrf机制，
        http.csrf(csrf -> csrf.disable());

        http.authorizeHttpRequests(auth->auth
                        .requestMatchers("/auth/**").permitAll()
                        .anyRequest()
                        .authenticated())
                // 配置httpBasic
                .httpBasic(Customizer.withDefaults());

        return http.build();

    }

    /**
     * 定义需要忽略的请求路径
     * @return
     */
    @Bean
    public WebSecurityCustomizer ignoringCustomizer(){
        //忽略认证的的路径请求
        return (web) -> web.ignoring()
                .requestMatchers(
                        "/hello",
                        "/hello2"
                );
    }

}
