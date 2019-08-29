

package io.agilefast.authserver.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.agilefast.authserver.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 系统用户
 * 
 * @author
 * @email
 * @date 2016年9月18日 上午9:34:11
 */
@Mapper
public interface SysUserDao extends BaseMapper<SysUserEntity> {
	


}
