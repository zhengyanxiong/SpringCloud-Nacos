

package io.agilefast.authserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.agilefast.authserver.entity.SysUserEntity;


import java.util.List;
import java.util.Map;


/**
 * 系统用户
 * 
 * @author
 * @email
 * @date 2016年9月18日 上午9:43:39
 */
public interface SysUserService extends IService<SysUserEntity> {

    SysUserEntity getUserByUsername(String username);
}
