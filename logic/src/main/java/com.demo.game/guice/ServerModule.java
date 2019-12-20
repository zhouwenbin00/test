package com.demo.game.guice;

import com.demo.game.Launcher;
import com.demo.game.logic.cmd.script.StopCmdScript;
import com.demo.game.logic.http.script.GmController;
import com.demo.game.logic.http.handler.HttpServerHandler;
import com.google.inject.AbstractModule;

/**
 * guice
 *
 * @author zwb
 */
public class ServerModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Launcher.class);
        bind(StopCmdScript.class);
        bind(HttpServerHandler.class);
        bind(GmController.class);
    }
}
