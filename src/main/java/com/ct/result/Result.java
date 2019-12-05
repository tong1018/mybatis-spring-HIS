package com.ct.result;

public class Result<T> {
    private int code;
    private String msg;
    private T data;

    public Result(ResultCode resultCode, T data){
        this(resultCode);
        this.data = data;
    }

    public Result(ResultCode resultCode){
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }

    public Result(int code,String msg,T data){
        this.data = data;
        this.msg = msg;
        this.code = code;
    }



    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}

