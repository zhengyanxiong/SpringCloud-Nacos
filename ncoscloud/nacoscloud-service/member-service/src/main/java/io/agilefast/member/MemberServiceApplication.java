package io.agilefast.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: Bernie
 * @Date: 2019-08-16 11:07
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableSwagger2
public class MemberServiceApplication {
    public static void main(String[] args){
        SpringApplication.run(MemberServiceApplication.class,args);
    }
}
