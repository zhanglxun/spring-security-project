package com.sense.provider.auth.config;

//import com.sense.provider.auth.security.SensePasswordEncoder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.DefaultSecurityFilterChain;

//@Configuration
//public class WebSecurityConfig  {
//
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails userDetails = User
//                .withUsername("user")
//                .password("$2a$10$K/Y1kttXG9aNHOhjneXVku9kxC36uQjc9d36yQXhHjHRwf/ciGT/a")  // BCrypt： 123456
//                //.password(new BCryptPasswordEncoder().encode("123456"))
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(userDetails);
//    }
//
//    //创建一个Encoder类型
//    @Bean
//    public SensePasswordEncoder sensePasswordEncoder(){
//        return new SensePasswordEncoder();
//    }
//
//}
