package com.sense.form.config;

import com.sense.form.handler.*;
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
        //关闭CSRF机制
        http.csrf(csrf->csrf.disable());
        // 关闭跨域
        http.cors(cors->cors.disable());

        http.authorizeHttpRequests(auth->auth
                        .requestMatchers("/auth/**","/logout","/login")
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                );
        // 配置httpBasic
        //http.httpBasic(Customizer.withDefaults());

        http.formLogin(formLogin -> formLogin.loginPage("/login") // 跳转到自定的登录页面
                .loginProcessingUrl("/login") // 处理前端的请求，与form表单的action一致
                .usernameParameter("username") // 用户名
                .passwordParameter("password") // 密码
                .defaultSuccessUrl("/index") // 请求到index接口上
                .successHandler(new JsonAuthenticationSuccessHandler())
                .failureHandler(new JsonAuthenticationFailureHandler())

        );

        http.logout(logout->logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .addLogoutHandler(new JsonLogoutHandler())
                .deleteCookies("JSESSIONID")

        );
        // 异常处理
        http.exceptionHandling(exception->exception
                .accessDeniedHandler(new JsonAccessDeniedHandler()) // 权限不足
                .authenticationEntryPoint(new JsonAuthenticationEntryPoint()) // 未登录认证入口
        );

        return http.build();
    }
}
