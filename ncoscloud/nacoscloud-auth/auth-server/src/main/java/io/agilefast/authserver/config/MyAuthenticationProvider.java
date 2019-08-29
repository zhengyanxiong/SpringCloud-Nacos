package io.agilefast.authserver.config;

import io.agilefast.authserver.entity.SysUserEntity;
import io.agilefast.authserver.service.OauthUserDetailsService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

/**
 * @Author: Bernie
 * @Date: 2019-08-15 10:06
 */
@Component
public class MyAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    OauthUserDetailsService userDetailsService;

    //加密算法
    private String  hashAlgorithmName = "SHA-256";
    //循环次数
    private int hashIterations = 16;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();


        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        //验证用户名
        if(userDetails == null||userDetails.getUsername() == null){
            throw new UsernameNotFoundException("用户名未找到");
        }
        String salt = ((SysUserEntity)userDetails).getSalt();
        //验证用户密码
        SimpleHash simpleHash1 = new SimpleHash(hashAlgorithmName, password, salt, hashIterations);
        boolean isTrue = userDetails.getPassword().equals(simpleHash1.toString()) ? true : false;

        if(isTrue){
            return new UsernamePasswordAuthenticationToken(username, null, userDetails.getAuthorities());
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
