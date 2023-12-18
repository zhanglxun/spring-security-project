package com.sense.base.auth.config;

import com.sense.base.auth.handler.LoginFailHandler;
import com.sense.base.auth.handler.LoginSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.server.authentication.logout.DelegatingServerLogoutHandler;
import org.springframework.security.web.server.authentication.logout.SecurityContextServerLogoutHandler;
import org.springframework.security.web.server.authentication.logout.WebSessionServerLogoutHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    LogoutSuccessHandler logoutSuccessHandler;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // 配置关闭csrf机制，
        http.csrf(csrf -> csrf.disable());

        http
                .authorizeHttpRequests(auth->auth
                        .requestMatchers("/auth/**")
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                )
                .formLogin(formLogin->formLogin
                        //.loginProcessingUrl("/auth/login")
                        .successHandler(new LoginSuccessHandler())
                        .failureHandler(new LoginFailHandler()
                )
        );
        // 配置httpBasic
        //.httpBasic(Customizer.withDefaults());

        http.logout(logout->logout
                .logoutSuccessUrl("/login")
                .logoutUrl("/logout")
                .addLogoutHandler((request, response, authentication) -> {
                    System.out.println(request.getMethod());
                    System.out.println("===========LogoutHandler============");
                })

        );

        http.csrf(csrf->csrf.disable());
        http.cors(cors->cors.disable());

        return http.build();

    }

    /**
     *
     * 这个是注销logout 按照这个测试成功的
     * https://juejin.cn/post/7153067327255232548
     */

    /**
     * 定义需要忽略的请求路径
     * @return
     */
  /*  @Bean
    public WebSecurityCustomizer ignoringCustomizer(){
        //忽略认证的的路径请求
        return (web) -> web.ignoring()
                .requestMatchers(
                        "/hello"
                );
    }*/

    @Bean
    public UserDetailsService userDetailsService(){

        InMemoryUserDetailsManager UserDetailsManager=new InMemoryUserDetailsManager();

        UserDetails adminUser= User.withUsername("jarvis")
                .password(new BCryptPasswordEncoder().encode("123456"))
                .roles("admin")
                .build();
        UserDetails vipUser=User.withUsername("user")
                 .password(new BCryptPasswordEncoder().encode("123456"))
                 .roles("user")
                  .build();

        UserDetailsManager.createUser(adminUser);
        UserDetailsManager.createUser(vipUser);
        return UserDetailsManager;
    }

    /**
     * 密码加密策略方法
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        // 构建密码编码器
        return new BCryptPasswordEncoder();
    }

}
