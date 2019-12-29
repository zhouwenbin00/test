package com.demo.game.logic.http;

import com.demo.game.logic.http.request.Request;
import com.demo.game.logic.http.response.Response;

/**
 * 抽象的http请求控制器
 * @author zwb
 */
public abstract class AbstractController {

    private final HttpControllerManager httpControllerManager;

    protected AbstractController(HttpControllerManager httpControllerManager) {
        this.httpControllerManager = httpControllerManager;
        httpControllerManager.register(this);
    }

    /**
     * 返回请求路径
     *
     * @return 请求路径
     */
    public abstract HttpType type();

    /**
     * 处理请求
     *
     * @param request 请求
     * @return 结果
     */
    public abstract Response exec(Request request);
}
