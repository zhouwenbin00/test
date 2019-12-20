package com.demo.game.logic.http.response;

import lombok.Data;

/** 带数据的响应体@author zwb */
@Data
public class ResponseResult extends Response {

    /** 封装的响应码 */
    private HttpCode httpCode;

    /** 数据 */
    private Object data;

    public ResponseResult(HttpCode httpCode) {
        super(httpCode.stateCode, httpCode.message);
        this.httpCode = httpCode;
    }

    /**
     * 返回一个成功的响应
     *
     * @return 成功的响应
     */
    public static ResponseResult ok() {
        return new ResponseResult(HttpCode.OK);
    }

    /**
     * 设置数据
     *
     * @param data 数据
     * @return 响应
     */
    public ResponseResult boby(Object data) {
        this.data = data;
        return this;
    }
}
