package com.demo.game.logic.http.response;

/**
 * 状态吗枚举
 *
 * @author zwb
 */
public enum HttpCode {

    /** 成功 */
    OK(200, "success"),
    /** 失败 */
    FAIL(300, "fail"),
    ;

    public int stateCode;
    public String message;

    HttpCode(int stateCode, String message) {
        this.stateCode = stateCode;
        this.message = message;
    }
}
