package com.bernie.oauth.controller;

import org.springframework.security.oauth2.provider.AuthorizationRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @Author: Bernie
 * @Date: 2019-08-13 15:17
 */
@Controller
@SessionAttributes("authorizationRequest")  // 重要！
public class AuthorizationController {
    @RequestMapping("/oauth/confirm_access")
    public ModelAndView getAccessConfirmation(Map<String, Object> model, HttpServletRequest request) throws Exception {
        AuthorizationRequest authorizationRequest = (AuthorizationRequest) model.get("authorizationRequest");
        ModelAndView view = new ModelAndView();
        view.setViewName("authorization");
        view.addObject("clientId", authorizationRequest.getClientId());
        // 传递 scope 过去,Set 集合
        List<String> scopes = new ArrayList<>(authorizationRequest.getScope());
        for (int i =0;i<scopes.size();i++){
            scopes.set(i,"scope."+scopes.get(i));
        }

        view.addObject("scopes", scopes);
        // 拼接一下名字
        view.addObject("scopeName", String.join(",", authorizationRequest.getScope()));
        return view;
    }
}
