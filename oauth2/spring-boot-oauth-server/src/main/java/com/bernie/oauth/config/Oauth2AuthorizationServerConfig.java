package com.bernie.oauth.config;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.config.annotation.builders.ClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;

import java.time.Duration;

/**
 * @Author: Bernie
 * @Date: 2019-08-12 17:07
 */
@Configuration
@RequiredArgsConstructor
@EnableAuthorizationServer
public class Oauth2AuthorizationServerConfig  extends AuthorizationServerConfigurerAdapter {

    private @NonNull AuthenticationManager authenticationManager;
    private @NonNull ClientDetails clientDetails;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        /*clients.inMemory()
                .withClient("oauth2")
                .secret("$2a$10$wlgcx61faSJ8O5I4nLiovO9T36HBQgh4RhOQAYNORCzvANlInVlw2")
                .resourceIds("oauth2")
                .authorizedGrantTypes("password", "authorization_code", "refresh_token")
                .authorities("ROLE_ADMIN", "ROLE_USER")
                .scopes("all")
                .accessTokenValiditySeconds(Math.toIntExact(Duration.ofHours(1).getSeconds()))
                .refreshTokenValiditySeconds(Math.toIntExact(Duration.ofHours(1).getSeconds()))
                .redirectUris("http://baidu.com")
                .and()
                .withClient("test")
                .secret("$2a$10$wlgcx61faSJ8O5I4nLiovO9T36HBQgh4RhOQAYNORCzvANlInVlw2")
                .resourceIds("oauth2")
                .authorizedGrantTypes("password", "authorization_code", "refresh_token")
                .authorities("ROLE_ADMIN", "ROLE_USER")
                .scopes("all")
                .accessTokenValiditySeconds(Math.toIntExact(Duration.ofHours(1).getSeconds()))
                .refreshTokenValiditySeconds(Math.toIntExact(Duration.ofHours(1).getSeconds()))
                .redirectUris("http://baidu.com");*/
        configClient(clients);
    }

    /**
     * 多个客户端，读取配置文件获取
     * @param clients
     * @throws Exception
     */
    private void configClient(ClientDetailsServiceConfigurer clients) throws Exception {
        /**
         * 基于内存的客户端信息与令牌存储
         */
        InMemoryClientDetailsServiceBuilder builder = clients.inMemory();
        for (BaseClientDetails client : clientDetails.getClient()) {
            ClientDetailsServiceBuilder<InMemoryClientDetailsServiceBuilder>.ClientBuilder clientBuilder =
                    builder.withClient(client.getClientId());
            clientBuilder
                    .secret(client.getClientSecret())
                    .resourceIds(client.getResourceIds().toArray(new String[0]))
                    .authorizedGrantTypes(client.getAuthorizedGrantTypes().toArray(new String[0]))
                    .authorities(
                            AuthorityUtils.authorityListToSet(client.getAuthorities())
                                    .toArray(new String[0]))
                    .scopes(client.getScope().toArray(new String[0]));
            if (client.getAutoApproveScopes() != null) {
                clientBuilder.autoApprove(
                        client.getAutoApproveScopes().toArray(new String[0]));
            }
            if (client.getAccessTokenValiditySeconds() != null) {
                clientBuilder.accessTokenValiditySeconds(
                        client.getAccessTokenValiditySeconds());
            }
            if (client.getRefreshTokenValiditySeconds() != null) {
                clientBuilder.refreshTokenValiditySeconds(
                        client.getRefreshTokenValiditySeconds());
            }
            if (client.getRegisteredRedirectUri() != null) {
                clientBuilder.redirectUris(
                        client.getRegisteredRedirectUri().toArray(new String[0]));
            }
        }
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(this.authenticationManager);
    }
}