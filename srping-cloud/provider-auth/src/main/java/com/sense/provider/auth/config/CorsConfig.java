package com.sense.provider.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description: 跨域cors问题的配置服务类
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 允许跨域访问的路径
        registry.addMapping("/**")
                // 允许跨域访问的源
                .allowedOriginPatterns("*")
                // 允许请求方法
                .allowedMethods("GET", "HEAD", "POST","PUT", "DELETE", "OPTIONS")
                // 是否允许证书 不再默认开启
                .allowCredentials(true)
                // 允许前端获取的响应头
                .maxAge(3600)
                // 允许前端获取的响应头
                .allowedHeaders("*");
    }

}
