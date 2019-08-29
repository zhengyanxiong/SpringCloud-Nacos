package io.agilefast.authserver.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Bernie
 * @Date: 2019-08-13 15:03
 */
@Data
@Configuration
@ConfigurationProperties("application.security.oauth")
public class SecurityProperties {
    /**
     * 登录请求的路径，默认值 /authorization/form
     */
    private String loginProcessingUrl = "/authorization/form";
}
