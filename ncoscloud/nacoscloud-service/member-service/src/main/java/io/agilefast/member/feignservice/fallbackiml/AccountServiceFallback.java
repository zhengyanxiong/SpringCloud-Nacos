package io.agilefast.member.feignservice.fallbackiml;

import io.agilefast.member.domain.Balance;
import io.agilefast.member.domain.User;
import io.agilefast.member.feignservice.AccountService;
import org.springframework.stereotype.Component;

/**
 * @Author: Bernie
 * @Date: 2019-08-16 11:43
 */
@Component
public class AccountServiceFallback implements AccountService {
    @Override
    public User getUser(Integer id) {
        return new User(id,new Balance(0, 0, 0, "降级"));
    }
}
