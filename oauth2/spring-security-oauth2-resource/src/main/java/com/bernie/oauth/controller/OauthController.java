package com.bernie.oauth.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Bernie
 * @Date: 2019-08-14 13:54
 */
@RestController
@RequestMapping("/auth")
public class OauthController {
    /**
     * 获取当前登录的用户信息
     *
     * @param principal 用户信息
     * @return http 响应
     */
    @GetMapping("/me")
    public HttpEntity<?> oauthMe(Principal principal) {
        return ResponseEntity.ok(principal);
    }

    @GetMapping("/hello")
    public HttpEntity<?> hello(){
        Map<String,Object> m = new HashMap<>();
        m.put("code","100000");
        m.put("msg","success");
        m.put("data","Hello Authoritarian");
        return ResponseEntity.ok(m);
    }
}
