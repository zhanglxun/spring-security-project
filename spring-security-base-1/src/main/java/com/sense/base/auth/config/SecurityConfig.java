package com.sense.base.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // 配置关闭csrf机制，
        http.csrf(csrf -> csrf.disable());

        http.authorizeHttpRequests(auth->auth
//                        .requestMatchers("/").permitAll()
                        .anyRequest()
                        .authenticated())
                        // 配置httpBasic
                        .httpBasic(Customizer.withDefaults());

        return http.build();

    }

    @Bean
    public UserDetailsService userDetailsService(){

        InMemoryUserDetailsManager UserDetailsManager=new InMemoryUserDetailsManager();

        UserDetails adminUser= User.withUsername("jarvis")
                .password(new BCryptPasswordEncoder().encode("jarvis"))
                .roles("admin")
                .build();
        UserDetails vipUser=User.withUsername("user")
                .password(new BCryptPasswordEncoder().encode("user"))
                .roles("user")
                .build();

        UserDetailsManager.createUser(adminUser);
        UserDetailsManager.createUser(vipUser);
        return UserDetailsManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // 构建密码编码器
        return new BCryptPasswordEncoder();
    }
}
