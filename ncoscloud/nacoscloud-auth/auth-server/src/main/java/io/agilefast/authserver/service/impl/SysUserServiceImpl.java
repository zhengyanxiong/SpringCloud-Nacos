

package io.agilefast.authserver.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.*;

import io.agilefast.authserver.common.utils.PageUtils;
import io.agilefast.authserver.common.utils.Query;
import io.agilefast.authserver.dao.SysUserDao;
import io.agilefast.authserver.entity.SysUserEntity;
import io.agilefast.authserver.service.SysUserService;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 系统用户
 *
 * @author
 * @email
 * @date 2016年9月18日 上午9:46:09
 */
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {

    @Override
    public SysUserEntity getUserByUsername(String username)
    {
        SysUserEntity user=this.getOne(new QueryWrapper<SysUserEntity>()
                .eq("username",username));
        return user;
    }
}
