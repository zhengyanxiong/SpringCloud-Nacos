/*******************************************************
 *Copyright (c) 2017 All Rights Reserved.
 *JDK版本： 1.8
 *公司名称：
 *命名空间：io.agilefast.common.utils
 *文件名：  Query
 *版本号：  V1.0.0.0
 *创建人：  daixirui
 *电子邮箱：daixirui@live.com
 *创建时间：2018-09-21 15:55
 *描述：
 *
 *=====================================================
 *修改标记
 *修改时间：2018-09-21 15:55
 *修改人：  daixirui
 *版本号：  V1.0.0.0
 *描述：
 *
 /******************************************************/

package io.agilefast.authserver.common.utils;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 查询参数
 *
 * @author
 * @since 2.0.0 2017-03-14
 */
public class Query<T> extends LinkedHashMap<String, Object> {
	private static final long serialVersionUID = 1L;
    /**
     * mybatis-plus分页参数
     */
    private IPage<T> page;
    /**
     * 当前页码
     */
    private int currPage = 1;
    /**
     * 每页条数
     */
    private int limit = 10;

    /**
     * 构造函数
     * @param params UI参数
     */
    public Query(Map<String, Object> params){
        this.putAll(params);

        //分页参数
        if(params.get("page") != null){
            currPage = Integer.parseInt((String)params.get("page"));
        }
        if(params.get("limit") != null){
            limit = Integer.parseInt((String)params.get("limit"));
        }

        this.put("offset", (currPage - 1) * limit);
        this.put("page", currPage);
        this.put("limit", limit);

        //mybatis-plus分页
        this.page = new Page<>(currPage, limit);

        //排序
        /*if(StringUtils.isNotBlank(sidx) && StringUtils.isNotBlank(order)){
            this.page.setOrderByField(sidx);
            this.page.setAsc("ASC".equalsIgnoreCase(order));
        }*/

    }

    /**
     * 获取页面对象
     * @return
     */
    public IPage<T> getPage() {
        return page;
    }

    /**
     * 获取当前页码
     * @return
     */
    public int getCurrPage() {
        return currPage;
    }

    public int getLimit() {
        return limit;
    }
}
