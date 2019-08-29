package io.agilefast.member.feignservice.fallbackiml;

import io.agilefast.member.domain.Balance;
import io.agilefast.member.feignservice.BalanceService;
import org.springframework.stereotype.Component;

/**
 * @Author: Bernie
 * @Date: 2019-08-16 14:03
 */
@Component
public class BalanceServiceFallback implements BalanceService {
    @Override
    public Balance getBalance(Integer id) {
        return new Balance(0, 0, 0, "降级");
    }
}
