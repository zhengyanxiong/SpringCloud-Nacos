package io.agilefast.member.controller;

import com.bernie.br.member.api.MemberApi;
import com.bernie.br.member.entity.SysUserEntity;
import com.bernie.br.utils.R;
import io.agilefast.member.feignservice.AccountService;
import io.agilefast.member.feignservice.BalanceService;
import io.agilefast.member.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Bernie
 * @Date: 2019-08-16 11:04
 */
@Slf4j
@RestController
public class MemberController implements MemberApi {
    @Autowired
    SysUserService sysUserService;
    @Autowired
    AccountService accountService;
    @Autowired
    BalanceService balanceService;

    /**
     * 根据用户名或者用户对象
     * @param name
     * @return
     */
    @Override
    public R findUserByName(@RequestParam("name") String name) {
        SysUserEntity userEntity = sysUserService.findUserByName(name);
        if (userEntity == null)
            return R.error("用户不存在");
        //User user = accountService.getUser( (userEntity.getUserId()).intValue());
        return R.ok().put("userInfo",userEntity);
    }

    @Override
    public R findUser(SysUserEntity userEntity) {
        SysUserEntity userEntitys = sysUserService.findUserByName(userEntity.getUsername());
        if (userEntity == null)
            return R.error("用户不存在");
        //User user = accountService.getUser( (userEntity.getUserId()).intValue());
        return R.ok().put("userInfo",userEntity);
    }
}
