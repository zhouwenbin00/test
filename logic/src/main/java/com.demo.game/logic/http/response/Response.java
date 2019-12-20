package com.demo.game.logic.http.response;

import lombok.Data;

/**
 * 响应结构体
 *
 * @author zwb
 */
@Data
public class Response {

    /** 响应码 */
    private final int status;
    /** 信息 */
    private final String message;

    /**
     * 构造
     *
     * @param status 响应码
     * @param message 信息
     */
    public Response(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
