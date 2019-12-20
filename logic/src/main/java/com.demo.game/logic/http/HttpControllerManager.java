package com.demo.game.logic.http;

import com.google.inject.Singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * http请求控制器
 * @author zwb
 */
@Singleton
public class HttpControllerManager {

    private final Map<String, AbstractController> map = new HashMap<>();

    public void register(AbstractController abstractController) {
        map.put(abstractController.url(), abstractController);
    }

    public AbstractController getScript(String uri) {
        return map.get(uri);
    }
}
