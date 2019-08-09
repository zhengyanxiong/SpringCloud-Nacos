package com.bernie.springbootsecurityoauth2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Bernie
 * @Date: 2019-08-08 15:05
 */
@RestController
public class HelloController {
    @GetMapping("/hi")
    public String hi(String name){
        return "hi , " + name;
    }
}
