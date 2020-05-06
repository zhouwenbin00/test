package com.zwb.demo.jprotobuf.net.codec;

import com.zwb.demo.protobuf.Test;
import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.net.InetSocketAddress;

public class NettyClient {

    public static void main(String[] args) throws InterruptedException {
        Bootstrap client = new Bootstrap();

        // 第1步 定义线程组，处理读写和链接事件，没有了accept事件
        EventLoopGroup group = new NioEventLoopGroup();
        client.group(group);

        // 第2步 绑定客户端通道
        client.channel(NioSocketChannel.class);

        // 第3步 给NIoSocketChannel初始化handler， 处理读写事件
        client.handler(
                new ChannelInitializer<NioSocketChannel>() { // 通道是NioSocketChannel
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        // 字符串编码器，一定要加在SimpleClientHandler 的上面
                        ch.pipeline().addLast(new NettyProtobufDecoder());
                        ch.pipeline().addLast(new NettyProtobufEncoder());
                        // 找到他的管道 增加他的handler
                        ch.pipeline().addLast(new SimpleClientHandler());
                    }
                });

        // 连接服务器
        ChannelFuture future = client.connect("localhost", 9999).sync();

        // 发送数据给服务器
        Test.TestInfo.Builder builder = Test.TestInfo.newBuilder();
        builder.setAge(1);
        builder.setDesc("niupi");
        builder.setName("zhangsan");
        Test.TestInfo build = builder.build();
        future.channel().writeAndFlush(build);

        // 当通道关闭了，就继续往下走
        future.channel().closeFuture().sync();
    }
}
