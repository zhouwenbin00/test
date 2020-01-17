package com.demo.game;

import classloader.Application;
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

    public static void main(String method, String s) {
        System.out.println(method+s);
        Injector injector =
                Guice.createInjector(Stage.PRODUCTION, new ServerModule(), new MessageModule());
        Launcher launcher = injector.getInstance(Launcher.class);
        launcher.run();
    }

    public static void main(String[] args) throws Exception {
        Application.run(Main.class, "main", "Post", "get");
    }
}
