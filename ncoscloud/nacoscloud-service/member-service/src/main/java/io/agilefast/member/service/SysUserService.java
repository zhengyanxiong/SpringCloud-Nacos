package io.agilefast.member.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.bernie.br.member.entity.SysUserEntity;

/**
 * @Author: Bernie
 * @Date: 2019-08-16 11:10
 */
public interface SysUserService extends IService<SysUserEntity> {
    SysUserEntity findUserByName(String userName);
}
