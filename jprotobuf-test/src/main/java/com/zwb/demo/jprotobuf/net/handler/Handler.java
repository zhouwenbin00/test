package com.zwb.demo.jprotobuf.net.handler;

import com.google.protobuf.Message;
import com.zwb.demo.jprotobuf.net.kek.Player;

public abstract class Handler<M extends Message> {

    public abstract void exec(Player player, M message);
}
