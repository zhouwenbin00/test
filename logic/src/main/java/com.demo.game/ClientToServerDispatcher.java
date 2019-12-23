package com.demo.game;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/** @author zwb */
@Singleton
public class ClientToServerDispatcher implements Dispatcher {

    private ClientToServerMessageHandlerFactory clientToServerMessageHandlerFactory;

    @Inject
    public ClientToServerDispatcher(
            ClientToServerMessageHandlerFactory clientToServerMessageHandlerFactory) {
        this.clientToServerMessageHandlerFactory = clientToServerMessageHandlerFactory;
    }



}
