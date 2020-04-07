package com.zwb.demo.jprotobuf.net.codec;

import com.google.protobuf.MessageLite;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class NettyProtobufEncoder extends MessageToByteEncoder<MessageLite> {

    protected void encode(ChannelHandlerContext ctx, MessageLite message, ByteBuf out) throws Exception {
        // -------------消息协议格式------------
        // length | id        |body
        // int     | int       |byte[]  |
        byte[] body = message.toByteArray();

        final int metaSize = 4;
        out.writeInt(metaSize + body.length);
        out.writeInt(1);
        out.writeBytes(body);
    }
}
