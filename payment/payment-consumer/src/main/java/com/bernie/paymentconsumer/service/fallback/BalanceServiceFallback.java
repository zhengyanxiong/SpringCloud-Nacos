package com.bernie.paymentconsumer.service.fallback;

import com.bernie.paymentconsumer.pojo.Balance;
import com.bernie.paymentconsumer.service.BalanceService;
import org.springframework.stereotype.Component;

/**
 * @Author: Bernie
 * @Date: 2019-08-06 15:17
 */
@Component
public class BalanceServiceFallback implements BalanceService {

    @Override
    public Balance getBalance(Integer id) {
        return new Balance(0,0,0,"降级");
    }
}
