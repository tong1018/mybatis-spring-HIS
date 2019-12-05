package com.ct.controller;


import com.ct.entity.HisUser;
import com.ct.model.HisUserModel;
import com.ct.result.Result;
import com.ct.service.implement.LoginService;
import com.ct.utils.ResultUtil;
import com.ct.utils.TokenUtil;
import com.ct.utils.annotations.CurrentUser;
import com.ct.utils.annotations.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


@RestController
@RequestMapping("/api/user")
public class LoginController {
    @Autowired
    LoginService loginService;


    @GetMapping("/test")
    public String test(){
        return "test fafafa";
    }


    //是否可以登录
    @PostMapping("/login")
    public Result checkPassword(@RequestBody @Valid  HisUserModel hisUserModel, HttpServletResponse response){
        HisUser hisUser = loginService.checkPassword(hisUserModel.getUsername(),hisUserModel.getPassword());
        //新建token
        String token = TokenUtil.createJwtToken(hisUser.getUsername(),5000000);


        response.setHeader("Access-Control-Expose-Headers", "Authorization");
        response.setHeader("Authorization",token);


        System.out.println("new token : "+hisUser.getUsername()+"-"+token);
        return ResultUtil.success(hisUser);

    }




    @UserLogin
    @PostMapping("/tokentest")
    public Result testtoken(@CurrentUser HisUser hisUser, HttpServletRequest request, HttpServletResponse httpServletResponse){
        //System.out.println("request"+request.getAttribute("CurrentUser"));
        System.out.println(hisUser.toString());
        return ResultUtil.success(hisUser);
    }

//    @PostMapping("/current")
//    public String testcurrent(HisUserModel){
//
//    }

    //获取用户权限
}
