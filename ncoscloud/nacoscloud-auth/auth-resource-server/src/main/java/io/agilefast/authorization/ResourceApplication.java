package io.agilefast.authorization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 启动类
 *
 * @author <a href="https://echocow.cn">EchoCow</a>
 * @date 19-7-9 下午9:07
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ResourceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ResourceApplication.class, args);
    }
}
