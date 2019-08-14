package com.bernie.oauth.config;



import com.bernie.oauth.exception.AuthTokenExceptions;
import com.bernie.oauth.exception.CustomAccessDeniedExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @Author: Bernie
 * @Date: 2019-08-14 13:55
 */
@Configuration
@EnableResourceServer
public class Oauth2ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Autowired
    CustomAccessDeniedExceptions customAccessDeniedException;
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        // 设置资源服务器的 id
        resources.resourceId("userResource");
        resources.authenticationEntryPoint(new AuthTokenExceptions())
                .accessDeniedHandler(customAccessDeniedException);
    }
}
