package com.demo.core.net.server;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import lombok.extern.slf4j.Slf4j;

/**
 * tcp服务器
 *
 * @author zwb
 */
@Slf4j
public class TcpServer implements Server {

    /** 处理Accept连接事件的线程，这里线程数设置为1即可，netty处理链接事件默认为单线程，过度设置反而浪费cpu资源 */
    private final EventLoopGroup bossGroup = new NioEventLoopGroup(1);

    /** 处理handler的工作线程，其实也就是处理IO读写 。线程数据默认为 CPU 核心数乘以2 */
    private final EventLoopGroup workerGroup = new NioEventLoopGroup();

    /** 端口 */
    private int port;

    /** 名字 */
    private String name;

    @Override
    public void start() {
        log.info("服务器开始启动");
        // todo
        log.info("服务器启动完成");
    }

    @Override
    public void stop() {
        log.info("服务器开始关闭");
        // todo
        log.info("服务器关闭完成");
    }
}
