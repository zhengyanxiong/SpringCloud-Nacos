package com.bernie.paymentconsumer.controller;

import com.bernie.paymentconsumer.pojo.User;
import com.bernie.paymentconsumer.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static javax.swing.UIManager.put;

/**
 * @Author: Bernie
 * @Date: 2019-08-06 15:10
 */
@RestController
public class AccountController {
    @Autowired
    BalanceService balanceService;

    final static Map<Integer, User> userMap = new HashMap() {{
        put(1, new User(1, "张三"));
        put(2, new User(2, "李四"));
        put(3, new User(3, "王五"));
    }
    };

    @RequestMapping("/acc/user")
    public User getUser(@RequestParam Integer id) {
        if(id != null && userMap.containsKey(id)) {
            User user = userMap.get(id);
            user.setBalance(balanceService.getBalance(id));
            return user;
        }
        return new User(0, "");
    }
}

