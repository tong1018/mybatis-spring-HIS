package com.ct.config;

import com.ct.utils.annotations.CurrentUserID;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.support.MissingServletRequestPartException;


public class CurrentUserIDMethodArgumentResolver implements HandlerMethodArgumentResolver{
    @Override
    public boolean supportsParameter(MethodParameter parameter){
        System.out.println("----------supportsParameter-----------" + parameter.getParameterType());
        boolean a = parameter.getParameterType().isAssignableFrom(int.class);
        boolean c = parameter.hasParameterAnnotation(CurrentUserID.class);
        boolean b = parameter.getParameterType().isAssignableFrom(int.class) //判断是否能转换成User类型
                && parameter.hasParameterAnnotation(CurrentUserID.class);
        if(a){
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
        int hisUserID = -1;
        hisUserID = (int) webRequest.getAttribute("CurrentUserID", RequestAttributes.SCOPE_REQUEST);
        if (hisUserID != -1) {
            System.out.println("currentID"+hisUserID);
            return hisUserID;
        }
        throw new MissingServletRequestPartException("CurrentUserID");
    }
}
