package com.demo.core.net;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;
import lombok.extern.slf4j.Slf4j;

/**
 * http服务器
 *
 * @author zwb
 */
@Slf4j
public class HttpServer implements Server {

    private EventLoopGroup bossGroup;
    private EventLoopGroup workerGroup;
    private AbstractHttpServerHandler httpServerHandler;
    private int port;
    private String name;

    public HttpServer(int port, String name, AbstractHttpServerHandler httpServerHandler) {
        this.port = port;
        this.name = name;
        this.httpServerHandler = httpServerHandler;
        bossGroup = new NioEventLoopGroup(1);
        workerGroup = new NioEventLoopGroup(4);
    }

    @Override
    public void start() {
        log.info("服务器{}准备启动...", name);
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap
                    .group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(
                            new ChannelInitializer<SocketChannel>() {
                                @Override
                                public void initChannel(SocketChannel ch) {
                                    ChannelPipeline pipeline = ch.pipeline();
                                    pipeline.addLast(new HttpServerCodec());
                                    pipeline.addLast(httpServerHandler);
                                }
                            });
            ChannelFuture f = serverBootstrap.bind(port).sync();
            log.info("{}启动完成...,端口:{}", name, port);
            f.channel().closeFuture().sync();
        } catch (Exception e) {
            log.error(name + "启动失败,造成原因:", e);
        }
    }

    @Override
    public void stop() {
        log.info("{}即将关闭...", name);
        workerGroup.shutdownGracefully();
        bossGroup.shutdownGracefully();
        log.info("{}关闭完成...", name);
    }

    public static void main(String[] args) {
        HttpServer server = new HttpServer(9999, "gm服务器", null);

        server.start();
    }
}
