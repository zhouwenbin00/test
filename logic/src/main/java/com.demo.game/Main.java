package com.demo.game;

import com.demo.game.guice.MessageModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Stage;
import com.demo.game.guice.ServerModule;

/**
 * main方法
 *
 * @author zwb
 */
public class Main {

    public static void main(String[] args) {
        Injector injector =
                Guice.createInjector(Stage.PRODUCTION, new ServerModule(), new MessageModule());
        Launcher launcher = injector.getInstance(Launcher.class);
        launcher.run();
    }
}
