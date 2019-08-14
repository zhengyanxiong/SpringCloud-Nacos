package com.bernie.oauth.controller;

import com.bernie.oauth.config.SecurityProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: Bernie
 * @Date: 2019-08-13 15:11
 */
@Controller
@RequestMapping("/oauth")
@RequiredArgsConstructor
public class OauthController {
    @Autowired
    SecurityProperties securityProperties;

    @GetMapping("login")
    public ModelAndView loginView() {
        ModelAndView md = new ModelAndView("login");
        md.addObject("action", securityProperties.getLoginProcessingUrl());
        md.addObject("loginError",false);
        return md;
    }

    @GetMapping("login-error")
    public ModelAndView loginError(){
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("loginError",true);
        modelAndView.addObject("action", securityProperties.getLoginProcessingUrl());
        return modelAndView;
    }
}
