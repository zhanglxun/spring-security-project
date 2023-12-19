package com.sense.base.auth.config;

import com.sense.base.auth.handler.*;
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
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        //关闭CSRF机制
        http.csrf(csrf->csrf.disable());
        // 关闭跨域
        http.cors(cors->cors.disable());

        http
                .authorizeHttpRequests(auth->auth
                        .requestMatchers("/auth/**","/logout","/login")
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                )
                .formLogin(formLogin->formLogin
                        .loginProcessingUrl("/login")
                        .successHandler(new JsonAuthenticationSuccessHandler())
                        .failureHandler(new JsonAuthenticationFailureHandler()
                )
        );
        // 配置httpBasic
        //http.httpBasic(Customizer.withDefaults());

        //注销退出
        http.logout(logout->logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .addLogoutHandler(new JsonLogoutHandler())
                .deleteCookies("JSESSIONID")

        );
        // 异常处理
        /*http.exceptionHandling(exception->exception
                .accessDeniedHandler(new JsonAccessDeniedHandler()) // 权限不足
                .authenticationEntryPoint(new JsonAuthenticationEntryPoint()) // 未登录认证入口
        );*/
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
