package com.star.response;

import java.io.Serializable;

/**
 * @ClassName: Response
 * @Description: TODO
 * @Author ONESTAR
 * @Date: 2021/1/22 22:55
 * @微信：YXK-ONESTAR
 * @URL：https://onestar.newstar.net.cn/
 * @Version 1.0
 */
public class Response<T> implements Serializable {
    private static final long serialVersionUID = -4505655308965878999L;

    //请求成功返回码为：0000
    private static final String successCode = "0000";
    //返回数据
    private T data;
    //返回码
    private String code;
    //返回描述
    private String msg;

    public Response(){
        this.code = successCode;
        this.msg = "请求成功";
    }

    public Response(String code, String msg){
        this();
        this.code = code;
        this.msg = msg;
    }
    public Response(String code, String msg, T data){
        this();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public Response(T data){
        this();
        this.data = data;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static String getSuccessCode() {
        return successCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
