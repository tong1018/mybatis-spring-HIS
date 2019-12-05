package com.ct.result;

public enum ResultCode {
//    枚举内容
    SUCCESS(0, "请求成功"),
    WEAK_NET_WORK(-1, "网络异常，请稍后重试"),
    DATA_READ_ERROR(10010,"数据读取异常"),
    PASSWORD_ERROR(10001, "用户名或密码错误"),
    PATIENT_NOT_EXIST(10011,"没有该患者信息，请完善基本资料"),
    PARAMETER_ERROR(10101, "参数错误"),
    NO_TOKEN(10110,"无Token，登录过期，请重新登录"),
    TOKEN_NOT_USEFUL(10111,"401，Token失效"),
    USER_NOT_EXIST(11000,"用户不存在"),
    INSERT_FAIL(11001,"数据添加失败"),
    DEL_FAIL(11011,"删除失败");



   private int code;
   private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode(){
        return this.code;
    }

    public String getMsg(){
        return this.msg;
    }
}
