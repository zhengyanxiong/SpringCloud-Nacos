/*******************************************************
 *Copyright (c) 2017 All Rights Reserved.
 *JDK版本： 1.8
 *公司名称：
 *命名空间：io.agilefast.gateway.config
 *文件名：  GatewayConfig 
 *版本号：  V1.0.0.0
 *创建人：  daixirui
 *电子邮箱：daixirui@live.com
 *创建时间：2019-08-19 17:02
 *描述：
 *
 *=====================================================
 *修改标记
 *修改时间：2019-08-19 17:02
 *修改人：  daixirui
 *版本号：  V1.0.0.0
 *描述：
 *
 /******************************************************/
package io.agilefast.gateway.config;

import io.agilefast.gateway.properties.PermitAllUrlProperties;
import io.agilefast.gateway.properties.ResourceServerProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * 配置
 * @author alpha
 * @since <pre>2019/04/09</pre>
 */
@Configuration
public class GatewayConfig {

    /**
     * webflux 静态资源配置
     * @return serverResponse
     */
    @Bean
    RouterFunction<ServerResponse> staticResourceRouter(){
        return RouterFunctions.resources("/webjars/**", new ClassPathResource("webjars/"));
    }

    @Bean
    @ConfigurationProperties(prefix = "auth")
    public PermitAllUrlProperties getPermitAllUrlProperties() {
        return new PermitAllUrlProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "security.oauth2")
    public ResourceServerProperties resourceServerProperties() {
        return new ResourceServerProperties();
    }
}
