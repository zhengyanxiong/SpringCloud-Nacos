/*******************************************************
 *Copyright (c) 2017 All Rights Reserved.
 *JDK版本： 1.8
 *公司名称：
 *命名空间：io.agilefast.authserver.config
 *文件名：  WebSecurityConfig 
 *版本号：  V1.0.0.0
 *创建人：  daixirui
 *电子邮箱：daixirui@live.com
 *创建时间：2019-08-09 16:31
 *描述：
 *
 *=====================================================
 *修改标记
 *修改时间：2019-08-09 16:31
 *修改人：  daixirui
 *版本号：  V1.0.0.0
 *描述：
 *
 /******************************************************/
package io.agilefast.authserver.config;
import io.agilefast.authserver.service.OauthUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Author: Bernie
 * @Date: 2019-08-12 17:04
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    OauthUserDetailsService userDetailsService;
    @Autowired
    SecurityProperties securityConfig;
    @Autowired
    MyAuthenticationProvider authenticationProvider;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.authenticationProvider(authenticationProvider);

        /*//校验用户
        auth.userDetailsService(userDetailsService).passwordEncoder(new PasswordEncoder() {
            //对密码进行加密
            @Override
            public String encode(CharSequence charSequence) {
                System.out.println("加密前："+charSequence.toString());
                return passwordEncoder().encode(charSequence.toString());
            }

            //对密码进行判断匹配
            @Override
            public boolean matches(CharSequence charSequence, String s) {

                return passwordEncoder().matches(charSequence.toString(),s);
            }
        });*/
    }



    /**
     * 密码加密方式，spring 5 后必须对密码进行加密
     *
     * @return BCryptPasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 认证管理
     *
     * @return 认证管理对象
     * @throws Exception 认证异常信息
     */
    @Override
    @Bean  // 重点是这行，父类并没有将它注册为一个 Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                //.loginPage("templates/login.html") //登录页面 resources 下的 resources 和 static 目录
                //.loginProcessingUrl("/authorization/form") ;//登录表单提交路径
                .loginPage("/oauth/login")  //模板引擎
                .loginProcessingUrl(securityConfig.getLoginProcessingUrl()) //获取模板引擎地址
                .failureUrl("/oauth/login-error")
                .and()
                .csrf().disable();// 关闭 csrf 防护，因为对于我们的所有请求来说，都是需要携带身份信息的
    }
    /**
     * 创建两个内存用户
     * 用户名 user 密码 123456 角色 ROLE_USER
     * 用户名 admin 密码 admin 角色 ROLE_ADMIN
     *
     * @return InMemoryUserDetailsManager
     */
    /*@Bean
    @Override
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user")
                .password(passwordEncoder().encode("123456"))
                .authorities("ROLE_USER").build());
        manager.createUser(User.withUsername("admin")
                .password(passwordEncoder().encode("admin"))
                .authorities("ROLE_ADMIN").build());
        return manager;
    }
*/

}
