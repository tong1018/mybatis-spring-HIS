package com.ct.service.inf;

import com.ct.entity.HisUser;

import java.util.List;

public interface LoginInterface {
//    进行用户登录判断
    public HisUser checkPassword(String username, String password);

//    获取用户权限
    public List<Object> getAuthority(String username);
}
