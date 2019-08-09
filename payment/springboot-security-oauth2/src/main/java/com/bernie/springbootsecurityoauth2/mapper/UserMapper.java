package com.bernie.springbootsecurityoauth2.mapper;

import com.bernie.springbootsecurityoauth2.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: Bernie
 * @Date: 2019-08-08 15:01
 */
@Mapper
public interface UserMapper {

    @Select( "select id , username , password from user where username = #{username}" )
    SysUser loadUserByUsername(@Param("username") String username);

}