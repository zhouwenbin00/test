package com.demo.game.guice;

import com.demo.game.ClientToServerMessageHandlerFactory;
import com.demo.game.logic.login.ReqLoginMessageHandler;
import com.google.inject.AbstractModule;

/** @author zwb */
public class MessageModule extends AbstractModule {

    @Override
    protected void configure() {
        // 自动生成
        bind(ClientToServerMessageHandlerFactory.class);
        bind(ReqLoginMessageHandler.class);
    }
}
