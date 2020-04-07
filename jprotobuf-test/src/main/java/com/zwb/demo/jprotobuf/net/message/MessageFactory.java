package com.zwb.demo.jprotobuf.net.message;

import com.google.protobuf.*;
import com.google.protobuf.Message;
import com.zwb.demo.protobuf.Test;

import java.util.HashMap;
import java.util.Map;

public class MessageFactory {
    private static final MessageFactory INSTANCE = new MessageFactory();
    private static Map<Integer, GeneratedMessage> map = new HashMap<Integer, GeneratedMessage>();

    public static MessageFactory getInstance() {
        return INSTANCE;
    }

    public Message create(int id, byte[] data) throws InvalidProtocolBufferException {
        GeneratedMessage message = map.get(id);
        Parser<? extends Message> parserForType = message.getParserForType();
        return parserForType.parseFrom(data);
    }

    static {
        map.put(1, Test.TestInfo.getDefaultInstance());
    }
}
