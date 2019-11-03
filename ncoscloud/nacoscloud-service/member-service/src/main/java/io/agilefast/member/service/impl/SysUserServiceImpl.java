package io.agilefast.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bernie.br.member.entity.SysUserEntity;
import io.agilefast.member.dao.SysUserDao;

import io.agilefast.member.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * @Author: Bernie
 * @Date: 2019-08-16 11:12
 */
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {
    @Override
    public SysUserEntity findUserByName(String userName) {
        SysUserEntity user = this.getOne(new QueryWrapper<SysUserEntity>()
                .eq("username", userName));
        return user;
    }


}
