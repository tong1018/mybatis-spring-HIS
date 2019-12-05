package com.ct.service.implement;

import com.ct.entity.HisUser;
import com.ct.exception.ResultException;
import com.ct.mapper.LoginMapper;
import com.ct.service.inf.LoginInterface;
import com.ct.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LoginService implements LoginInterface {

    @Autowired
    private LoginMapper loginMapper;

    //    进行用户登录判断
    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.READ_COMMITTED)
    @Override
    public HisUser checkPassword(String username, String password) {
        HisUser existUser =loginMapper.getUser(username);
        if(existUser==null||!existUser.getPassword().equals(password))
            throw new ResultException(ResultCode.PASSWORD_ERROR);
        return existUser;
    }

    //    获取用户权限
    @Override
    public List<Object> getAuthority(String username) {
        return null;
    }
}
