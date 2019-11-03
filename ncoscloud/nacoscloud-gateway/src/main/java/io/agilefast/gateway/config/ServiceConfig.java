package io.agilefast.gateway.config;

import io.agilefast.gateway.filter.AuthorizationFilter;
import io.agilefast.gateway.filter.HeaderEnhanceFilter;
import io.agilefast.gateway.properties.PermitAllUrlProperties;
import io.agilefast.gateway.properties.ResourceServerProperties;
import io.agilefast.gateway.security.CustomRemoteTokenServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableConfigurationProperties
@RibbonClient(name = "auth-server")
public class ServiceConfig {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private ResourceServerProperties resource;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    @Order(100)
    public CustomRemoteTokenServices customRemoteTokenServices(RestTemplate restTemplate) {
        CustomRemoteTokenServices resourceServerTokenServices = new CustomRemoteTokenServices(restTemplate);
        resourceServerTokenServices.setCheckTokenEndpointUrl(resource.getResource().getTokenInfoUri());
        resourceServerTokenServices.setClientId(resource.getClient().getClientId());
        resourceServerTokenServices.setClientSecret(resource.getClient().getClientSecret());
        resourceServerTokenServices.setLoadBalancerClient(loadBalancerClient);
        return resourceServerTokenServices;
    }

    @Bean
    public AuthorizationFilter authorizationFilter(CustomRemoteTokenServices customRemoteTokenServices,
                                                   HeaderEnhanceFilter headerEnhanceFilter,
                                                   PermitAllUrlProperties permitAllUrlProperties) {
        return new AuthorizationFilter(customRemoteTokenServices, headerEnhanceFilter, permitAllUrlProperties);
    }


    @Bean
    public HeaderEnhanceFilter headerEnhanceFilter() {
        return new HeaderEnhanceFilter();
    }

}
