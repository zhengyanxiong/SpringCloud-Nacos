package com.bernie.springbootsecurityoauth2.service;

import com.bernie.springbootsecurityoauth2.entity.Role;
import com.bernie.springbootsecurityoauth2.entity.SysUser;
import com.bernie.springbootsecurityoauth2.mapper.RoleMapper;
import com.bernie.springbootsecurityoauth2.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Bernie
 * @Date: 2019-08-08 14:57
 */
@Service
public class MyUserDetailsService implements UserDetailsService {
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
