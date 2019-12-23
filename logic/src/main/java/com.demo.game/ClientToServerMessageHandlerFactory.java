package com.demo.game;

import com.demo.game.logic.login.ReqLoginMessageHandler;
import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;

import java.util.HashMap;
import java.util.Map;

/** @author zwb */
@Singleton
public class ClientToServerMessageHandlerFactory implements MessageHandlerFactory {

    private final Map<Integer, MessageHandler> handlers;

    private final Injector injector;

    @Override
    public MessageHandler getHandler(int id) {
        return handlers.get(id);
    }

    @Inject
    public ClientToServerMessageHandlerFactory(Injector injector) {
        this.injector = injector;
        Map<Integer, MessageHandler> handlers = new HashMap<>();
        handlers.put(1, injector.getInstance(ReqLoginMessageHandler.class));
        this.handlers = ImmutableMap.copyOf(handlers);
    }
}
