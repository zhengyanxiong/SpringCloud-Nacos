package io.agilefast.member.feignservice;

import io.agilefast.member.domain.User;
import io.agilefast.member.feignservice.fallbackiml.AccountServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: Bernie
 * @Date: 2019-08-16 11:43
 */
@FeignClient(name = "account-service", fallback = AccountServiceFallback.class)
public interface AccountService {
    @RequestMapping(value = "/acc/user", method = RequestMethod.GET)
    User getUser(@RequestParam("id") Integer id);
}
