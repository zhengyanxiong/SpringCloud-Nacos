package com.bernie.paymentconsumer.service;

import com.bernie.paymentconsumer.pojo.Balance;
import com.bernie.paymentconsumer.service.fallback.BalanceServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: Bernie
 * @Date: 2019-08-06 15:16
 */
@FeignClient(name = "payment-service",fallback = BalanceServiceFallback.class)
public interface BalanceService {
    @RequestMapping(value = "/pay/balance", method = RequestMethod.GET)
    Balance getBalance(@RequestParam("id") Integer id);
}
