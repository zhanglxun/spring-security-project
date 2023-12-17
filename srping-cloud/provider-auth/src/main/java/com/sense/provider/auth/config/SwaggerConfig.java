package com.sense.provider.auth.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: swagger配置信息类
 */
@Configuration
public class SwaggerConfig {

    final static String WebSite = "http://www.susense.com";
    /**
     * 构建api文档
     * @return
     */
    @Bean
    public OpenAPI OpenAPI() {
        return new OpenAPI()
                .info(apiInfo())
                .externalDocs(new ExternalDocumentation());
    }

    /**
     * API文档信息
     * @return
     */
    private Info apiInfo() {
        return new Info()
                .title("认证和权限服务")
                .description("统一访问控制")
                .summary("SpringDoc文档")
                .termsOfService("")
                .version("1.0");
    }

}
