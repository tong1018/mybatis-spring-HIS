package com.ct.advice;

import com.alibaba.fastjson.JSON;
import com.ct.exception.ResultException;
import com.ct.result.Result;
import com.ct.result.ResultCode;
import com.ct.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Chery
 * @date 2017/5/1 - 下午1:39
 */
@ControllerAdvice
@ResponseBody
public class ExceptionHandlerAdvice implements ResponseBodyAdvice {

    private ThreadLocal<Object> modelHolder = new ThreadLocal<>();

    //获取日志信息
    private Logger logger = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

    //参数验证失败，抛出异常处理
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleIllegalParamException(MethodArgumentNotValidException e) {
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        String tips = "参数不合法";
        if (errors.size() > 0) {
            tips = errors.get(0).getDefaultMessage();
        }
        return ResultUtil.warn(ResultCode.PARAMETER_ERROR, tips);
    }

    //resultException处理
    @ExceptionHandler(ResultException.class)
    public Result handleResultException(ResultException e, HttpServletRequest request) {

        logger.debug("uri={} | requestBody={}", request.getRequestURI(),
                JSON.toJSONString(modelHolder.get()));
        return ResultUtil.warn(e.getResultCode());
    }


    //网络异常
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e, HttpServletRequest request) {
        logger.error("uri={} | requestBody={}", request.getRequestURI(),
                JSON.toJSONString(modelHolder.get()), e);
        return ResultUtil.warn(ResultCode.WEAK_NET_WORK);
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        // ModelHolder 初始化
        modelHolder.set(webDataBinder.getTarget());
    }

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        // ModelHolder 清理
        modelHolder.remove();
        return body;
    }
}
