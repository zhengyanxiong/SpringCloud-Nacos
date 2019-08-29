/*******************************************************
 *Copyright (c) 2017 All Rights Reserved.
 *JDK版本： 1.8
 *公司名称：
 *命名空间：io.agilefast.authserver.service
 *文件名：  OauthUserDetailsService 
 *版本号：  V1.0.0.0
 *创建人：  daixirui
 *电子邮箱：daixirui@live.com
 *创建时间：2019-08-13 14:07
 *描述：
 *
 *=====================================================
 *修改标记
 *修改时间：2019-08-13 14:07
 *修改人：  daixirui
 *版本号：  V1.0.0.0
 *描述：
 *
 /******************************************************/
package io.agilefast.authserver.service;


import io.agilefast.authserver.entity.SysUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: alpha
 * @Date: 2019-08-13 11:07
 */
@Service
public class OauthUserDetailsService implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //查数据库
        SysUserEntity user = sysUserService.getUserByUsername(s);
        return user;
    }
}
