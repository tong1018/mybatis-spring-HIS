package com.ct.utils;

import com.ct.result.Result;
import com.ct.result.ResultCode;

import java.util.ArrayList;
import java.util.List;

public class ResultUtil {

    public static Result success(Object data) {
        return new Result<>(ResultCode.SUCCESS, data);
    }

    //    创建新的提示返回信息
    public static Result warn(ResultCode resultCode, String msg) {
        Result<Object> result = new Result<>(resultCode);
        result.setMsg(msg);
        return result;
    }

    public static Result success(ResultCode resultCode,String msg){
        Result<Object> result = new Result<>(resultCode);
        result.setMsg(msg);
        return result;
    }


    public static Result successGetList(){
        List<Object> objects = new ArrayList<>();
        return new Result(ResultCode.SUCCESS,objects);
    }
    //    使用已有的返回信息
    public static Result warn(ResultCode resultCode) {
        List<Object> objects = new ArrayList<>();
        return new Result(resultCode,objects);
    }
}
