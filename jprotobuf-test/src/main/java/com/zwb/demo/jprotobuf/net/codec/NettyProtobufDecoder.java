package com.zwb.demo.jprotobuf.net.codec;

import com.google.protobuf.Message;
import com.zwb.demo.jprotobuf.net.message.MessageFactory;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class NettyProtobufDecoder extends ByteToMessageDecoder {


    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if (in.readableBytes() < 4) {
            // 可读字节小于4
            return;
        }

        // -------------消息协议格式------------
        // length | id        |body
        // int     | int       |byte[]  |

        // 读取消息头
        int length = in.readInt();
        System.out.println(String.format("消息长度为：%s", length));
        if (in.readableBytes() < length){
            System.out.println("可读长度异常");
        }
        final int metaSize = 4;
        int messageId = in.readInt();
        byte[] body = new byte[length - metaSize];
        in.readBytes(body);
        Message message = MessageFactory.getInstance().create(messageId, body);
        out.add(message);
    }
}
