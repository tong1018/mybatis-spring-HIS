package com.ct.mapper;

import com.ct.entity.HisUser;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginMapper {

    //根据用户名获取用户密码
    public HisUser getUser(String username);

    //根据用户获取用户权限
    public String getAuthority(String username);
}
