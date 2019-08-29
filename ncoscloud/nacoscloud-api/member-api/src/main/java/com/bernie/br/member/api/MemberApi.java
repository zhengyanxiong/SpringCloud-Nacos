package com.bernie.br.member.api;


import com.bernie.br.member.entity.SysUserEntity;
import com.bernie.br.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: Bernie
 * @Date: 2019-08-16 10:21
 */
@RequestMapping("/memberApi")
@Api(tags="member服务测试接口")
public interface MemberApi {

    @RequestMapping(value = "/findUserByName",method = RequestMethod.GET)
    @ApiOperation("通过用户名获取用户信息")
    @ApiImplicitParam(name = "name",value = "用户名",required = true)
    R findUserByName(@RequestParam("name") String name);

    @RequestMapping(value = "/findUser",method = RequestMethod.POST)
    @ApiOperation("post请求获取用户信息")
    R findUser(@RequestBody SysUserEntity userEntity);
}
