package com.example.forum.bean;


/**
 * 公共响应类
 * @param <T>
 */
public class Response<T> {

    private static final int CODE_SUCCESS = 200;

    private static final int CODE_FAIL = 500;

    private static final int CODE_ERROR = 500;// 一般错误

    private static final int CODE_NO_LOGIN = 300;

    public static final int CODE_EXIST = 10001; // 用户已存在

    private int code;

    private String msg;

    private T data;

    public Response(int code, String msg, T data) {
        this.setCode(code);
        this.setMsg(msg);
        this.setData(data);
    }

    public static <T> Response<T> success() {
        return new Response<T>(CODE_SUCCESS, "success", null);
    }
    public static <T> Response<T> success(String message) {
        return new Response<T>(CODE_SUCCESS, message, null);
    }
    public static <T> Response<T> success(T data) {
        return new Response<T>(CODE_SUCCESS, "success", data);
    }
    public static <T> Response<T> success(String message, T data) {
        return new Response<T>(CODE_SUCCESS, message, data);
    }

    public static <T> Response<T> error() {
        return new Response<T>(CODE_ERROR, "fail", null);
    }
    public static <T> Response<T> error(int code,String message) {
        return new Response<T>(code, message, null);
    }
    public static <T> Response<T> errorParams() {
        return new Response<T>(CODE_ERROR, "参数有误", null);
    }
    public static <T> Response<T> error(String message) {
        return new Response<T>(CODE_ERROR, message, null);
    }
    public static <T> Response<T> error(T data) {
        return new Response<T>(CODE_ERROR, "fail", data);
    }
    public static <T> Response<T> error(String message, T data) {
        return new Response<T>(CODE_ERROR, message, data);
    }

    public static <T> Response<T> badrequest() {
        return new Response<T>(CODE_FAIL, "no identifier arguments", null);
    }
    public static <T> Response<T> badrequest(String message) {
        return new Response<T>(CODE_FAIL, message, null);
    }
    public static <T> Response<T> badrequest(T data) {
        return new Response<T>(CODE_FAIL, "no identifier arguments", data);
    }
    public static <T> Response<T> badrequest(String message, T data) {
        return new Response<T>(CODE_FAIL, message, data);
    }

    public static <T> Response<T> noLogin(String message) {
        return new Response<T>(CODE_NO_LOGIN, message, null);
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static Response getResponse(int count){
        if (count > 0){
            return Response.success();
        }
        return Response.error();

    }

    public static Response getResponse(String message,boolean isSuccess){
       if (isSuccess){
           return success(message);
       }else {
           return error(message);
       }
    }

    public static <T> Response getResponse(T data){
        if (data != null){
            return Response.success(data);
        }
        return Response.error();
    }

    public static Response getUploadResponse(int errorCounts){
        if (errorCounts == 0){
            return Response.success("上传成功");
        }
        return Response.error("上传失败"+errorCounts+"个");
    }

}