package com.zwb.demo.jprotobuf.net.handler;

import com.zwb.demo.protobuf.Test;

import java.util.HashMap;
import java.util.Map;

public class HandlerFactory {
    private static final HandlerFactory INSTANCE = new HandlerFactory();
    private static  Map<Class<?>, Handler> map = new HashMap<Class<?>, Handler>();

    public Handler getHandler(Class<?> id){
        return map.get(id);
    }

    public static HandlerFactory getInstance() {
        return INSTANCE;
    }
    static {
        map.put(Test.TestInfo.class, new TestHandler());
    }
}
