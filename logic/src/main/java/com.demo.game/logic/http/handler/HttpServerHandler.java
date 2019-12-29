package com.demo.game.logic.http.handler;

import com.alibaba.fastjson.JSON;
import com.demo.core.net.handler.AbstractHttpServerHandler;
import com.demo.game.StringConstant;
import com.demo.game.logic.http.AbstractController;
import com.demo.game.logic.http.HttpControllerManager;
import com.demo.game.logic.http.HttpType;
import com.demo.game.logic.http.request.Request;
import com.demo.game.logic.http.response.Response;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.*;
import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;

/**
 * http请求处理器
 *
 * @author zwb
 */
@Singleton
@Slf4j
@ChannelHandler.Sharable
public class HttpServerHandler extends AbstractHttpServerHandler {

    private final HttpControllerManager httpControllerManager;

    @Inject
    public HttpServerHandler(HttpControllerManager httpControllerManager) {
        this.httpControllerManager = httpControllerManager;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof DefaultHttpRequest) {
            // 请求，解码器将请求转换成HttpRequest对象
            DefaultHttpRequest request = (DefaultHttpRequest) msg;
            // 获取请求参数
            log.info(
                    "收到http请求:{}---客户端ip:{}",
                    request.uri(),
                    ctx.channel().remoteAddress().toString());
            if (StringConstant.FAVICON_IOC.equals(request.uri())) {
                return;
            }
            Request req = createRequest(request);
            HttpType httpType = HttpType.create(req.getUrl());

            if (httpType == null) {
                log.warn("???没有对应脚本的请求:{}", req.getUrl());
                return;
            }
            AbstractController script = httpControllerManager.getScript(httpType);
            Response res = script.exec(req);

            ctx.writeAndFlush(createResponse(res));
        }
    }

    /**
     * 构建一个请求体
     *
     * @param request HttpRequest
     * @return 请求体
     */
    private Request createRequest(HttpRequest request) {
        QueryStringDecoder queryStringDecoder = new QueryStringDecoder(request.uri());
        return new Request(
                queryStringDecoder.path(), request.uri(), queryStringDecoder.parameters());
    }

    /**
     * 构建一个http响应
     *
     * @param response 响应
     * @return HttpResponse
     * @throws UnsupportedEncodingException 异常
     */
    private HttpResponse createResponse(Response response) throws UnsupportedEncodingException {
        String jsonString = JSON.toJSONString(response);
        log.info("返回响应结果:{}", jsonString);
        byte[] bytes = jsonString.getBytes("UTF-8");
        FullHttpResponse res =
                new DefaultFullHttpResponse(
                        HttpVersion.HTTP_1_1, HttpResponseStatus.OK, Unpooled.wrappedBuffer(bytes));
        res.headers().set("Content-Type", "text/html; charset=utf-8");
        res.headers().set("Content-Length", Integer.toString(bytes.length));
        return res;
    }
}
