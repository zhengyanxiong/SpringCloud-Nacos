package io.agilefast.member.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bernie.br.member.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: Bernie
 * @Date: 2019-08-16 11:13
 */
@Mapper
public interface SysUserDao extends BaseMapper<SysUserEntity> {
}
