package com.succulent.user.common;

/**
 * 实现回应结果的设定
 */
public class RespCode {

    public static RespCode SUCCESS = new RespCode("200", "Success");
    public static RespCode FAIL    = new RespCode("400", "Fail");
    public static RespCode PARAM_ERROR    = new RespCode("450", "Parameter error");
    public static RespCode IDENTITY_NULL    = new RespCode("460", "Identity null");
    public static RespCode GOODS_UNDERSTOCK    = new RespCode("470", "Goods understock");
    public static RespCode STAT_ILLEGAL    = new RespCode("480", "Stat illegal");


    // MARK: RespCode

    private String code;
    private String msg;

    public RespCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
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
