package com.bernie.oauth.service;

import com.bernie.oauth.entity.Role;
import com.bernie.oauth.entity.SysUser;
import com.bernie.oauth.mapper.RoleMapper;
import com.bernie.oauth.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Bernie
 * @Date: 2019-08-13 11:07
 */
@Service
public class OauthUserDetailsService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //查数据库
        SysUser user = userMapper.loadUserByUsername( s );
        if (null != user) {
            List<Role> roles = roleMapper.getRolesByUserId( user.getId() );
            user.setAuthorities( roles );
        }
        return user;
    }
}
