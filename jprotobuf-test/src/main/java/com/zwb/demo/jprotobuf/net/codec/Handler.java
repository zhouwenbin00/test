package com.zwb.demo.jprotobuf.net.codec;

import com.google.protobuf.Message;

public abstract class Handler<M extends Message> {

    public abstract void exec(Player player, M message);
}
