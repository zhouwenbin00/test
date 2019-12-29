package com.demo.game.guice;

import com.demo.game.Launcher;
import com.demo.game.logic.activity.ActivityManager;
import com.demo.game.logic.activity.script.TestActivityScript;
import com.demo.game.logic.cmd.script.StopCmdScript;
import com.demo.game.logic.http.script.ActivityController;
import com.demo.game.logic.http.script.GmController;
import com.demo.game.logic.http.handler.HttpServerHandler;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

/**
 * guice
 *
 * @author zwb
 */
public class ServerModule extends AbstractModule {

    @Override
    protected void configure() {
        bindSingleton(ActivityManager.class);
        bindSingleton(GmController.class);
        bindSingleton(HttpServerHandler.class);
        bindSingleton(StopCmdScript.class);
        bindSingleton(Launcher.class);
        bindSingleton(TestActivityScript.class);
        bindSingleton(ActivityController.class);
    }

    /**
     * 绑定单列
     *
     * @param clazz
     */
    protected void bindSingleton(Class<?> clazz) {
        bind(clazz).in(Singleton.class);
    }
}
