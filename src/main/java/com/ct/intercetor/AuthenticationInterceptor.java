package com.ct.intercetor;

import com.ct.entity.HisUser;
import com.ct.exception.ResultException;
import com.ct.mapper.LoginMapper;
import com.ct.result.ResultCode;
import com.ct.utils.TokenUtil;
import com.ct.utils.annotations.PassToken;
import com.ct.utils.annotations.UserLogin;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class AuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    LoginMapper loginMapper;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,Object object){

        //设置梭允许的ajax访问域名应用
        httpServletResponse.setHeader("Access-Control-Allow-Origin","*");
        httpServletResponse.setHeader("Access-Control-Allow-Methods","GET,PUT,POST,DELETE,HEAD");
        httpServletResponse.setHeader("Access_Control-Allow-Headers","Origin,X-Requested-With,content-Type,Accept,Authorization");
        httpServletResponse.setHeader("Access-Control-Max-Age","3600");

        //获取请求头token
        String token = "";
        String authorization = httpServletRequest.getHeader("Authorization");
        if (authorization!=null){
            if(authorization.indexOf("Bearer ")!=-1){
                token += authorization.split(" ")[1];
            }else {
                token = authorization;
            }


        }
       System.out.println("authorization:::::::"+authorization);
        //如果不是映射到方法直接通过
        if(!(object instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();



        //检验是否含有passtoken注释，有则跳过验证
        if(method.isAnnotationPresent(PassToken.class)){
            PassToken passToken = method.getAnnotation(PassToken.class);
            if(passToken.required()){
                return true;
            }
        }

        //检查是否有需要用户权限的注释
        if(method.isAnnotationPresent(UserLogin.class)){
            UserLogin userLoginToken = method.getAnnotation(UserLogin.class);
            if(userLoginToken.required()){
                //执行验证
                if(token==null||token.equals("")){
                    throw new ResultException(ResultCode.NO_TOKEN);
                }else{
                    //获取token中的用户信息
                    Claims claims;

                    //验证token
                    try{
                        claims = TokenUtil.parseJWT(token);
                    }catch (ExpiredJwtException e){
                        throw new ResultException(ResultCode.TOKEN_NOT_USEFUL);
                    }

                    //获取token中的用户名
                    String username = claims.getId();
                    HisUser hisUser = loginMapper.getUser(username);
                    if(hisUser==null){//检验用户是否存在
                        throw new ResultException(ResultCode.USER_NOT_EXIST);
                    }
                    httpServletRequest.setAttribute("CurrentUser",hisUser);
                    httpServletRequest.setAttribute("CurrentUserID",hisUser.getId());

                }
            }
        }
        return true;
    }

    // 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }
    // 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {

    }

}
