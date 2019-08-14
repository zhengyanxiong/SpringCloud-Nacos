package com.bernie.oauth.entity;

import org.springframework.security.core.GrantedAuthority;

/**
 * @Author: Bernie
 * @Date: 2019-08-08 14:58
 */
public class Role implements GrantedAuthority {

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return name;
    }

}
