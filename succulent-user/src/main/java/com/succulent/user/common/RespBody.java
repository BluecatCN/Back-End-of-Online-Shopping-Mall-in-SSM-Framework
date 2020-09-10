package com.succulent.user.common;

/**
 * 实现对接收的回应信息进行处理
 */

public class RespBody {

    private String code;
    private String msg;
    private Object data;

    public RespBody(RespCode respCode) {
        this.code = respCode.getCode();
        this.msg  = respCode.getMsg();
    }

    public RespBody(RespCode respCode, Object data) {
        this.code = respCode.getCode();
        this.msg  = respCode.getMsg();
        this.data = data;
    }

    public RespBody(String code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

//    public RespBody(String code, String msg, Object data) {
//        this.code = code;
//        this.msg = msg;
//        this.data = data;
//    }

    public RespBody(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
