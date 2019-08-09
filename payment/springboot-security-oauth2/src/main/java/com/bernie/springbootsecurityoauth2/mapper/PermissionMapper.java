package com.bernie.springbootsecurityoauth2.mapper;

import com.bernie.springbootsecurityoauth2.entity.RolePermisson;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: Bernie
 * @Date: 2019-08-08 14:59
 */
@Mapper
public interface PermissionMapper {

    @Select( "SELECT A.NAME AS roleName,C.url FROM role AS A LEFT JOIN role_permission B ON A.id=B.role_id LEFT JOIN permission AS C ON B.permission_id=C.id" )
    List<RolePermisson> getRolePermissions();

}