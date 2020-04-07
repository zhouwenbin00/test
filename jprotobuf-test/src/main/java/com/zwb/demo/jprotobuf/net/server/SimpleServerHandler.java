package com.zwb.demo.jprotobuf.net.server;

import com.google.protobuf.Message;
import com.zwb.demo.jprotobuf.net.kek.Player;
import com.zwb.demo.jprotobuf.net.handler.Handler;
import com.zwb.demo.jprotobuf.net.handler.HandlerFactory;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;


public class SimpleServerHandler extends SimpleChannelInboundHandler<Message> {

    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Message message) throws Exception {
        System.out.println(message);
        Handler handler = HandlerFactory.getInstance().getHandler(message.getClass());
        handler.exec(new Player(), message);
    }
}
