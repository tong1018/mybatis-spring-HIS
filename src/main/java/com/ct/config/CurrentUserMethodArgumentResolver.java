package com.ct.config;

import com.ct.entity.HisUser;
import com.ct.utils.annotations.CurrentUser;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

/**
 * 自定义参数解析器（解析hisUsermodel）
 * 增加方法注入，将含有 @CurrentUser 注解的方法参数注入当前登录用户
 */
public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter){
        System.out.println("----------supportsParameter-----------" + parameter.getParameterType());
        boolean a = parameter.getParameterType().isAssignableFrom(HisUser.class);
        boolean c = parameter.hasParameterAnnotation(CurrentUser.class);
        boolean b = parameter.getParameterType().isAssignableFrom(HisUser.class) //判断是否能转换成User类型
                && parameter.hasParameterAnnotation(CurrentUser.class);
        if(b&&true){
            System.out.println("ture");
        }else {
            System.out.println("false");
        }

        return b; //是否有CurrentUser注解
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        System.out.println("--------------resolveArgument-------------" );
        HisUser hisUser = (HisUser) webRequest.getAttribute("CurrentUser", RequestAttributes.SCOPE_REQUEST);
        if (hisUser != null) {
            return hisUser;
        }
        throw new MissingServletRequestPartException("CurrentUser");
    }
}