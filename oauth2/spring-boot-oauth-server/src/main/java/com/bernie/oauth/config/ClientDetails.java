package com.bernie.oauth.config;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;

import java.util.List;

/**
 * @Author: Bernie
 * @Date: 2019-08-12 17:26
 */
@Data
@Getter
@Configuration
@ConfigurationProperties("application.security.oauth")
public class ClientDetails {
    private List<BaseClientDetails> client;
}
