package com.zwb.demo.jprotobuf.net.handler;

import com.zwb.demo.jprotobuf.net.kek.Player;
import com.zwb.demo.protobuf.Test;

public class TestHandler extends Handler<Test.TestInfo> {
    public void exec(Player player, Test.TestInfo message) {
        System.out.println(message);
    }
}
