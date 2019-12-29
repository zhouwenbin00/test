package com.demo.game.logic.http;

import com.demo.core.lang.EnumArray;
import com.google.inject.Singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * http请求控制器
 *
 * @author zwb
 */
@Singleton
public class HttpControllerManager {

    private final EnumArray<HttpType, AbstractController> map = new EnumArray<>(HttpType.class);

    public void register(AbstractController abstractController) {
        map.set(abstractController.type(), abstractController);
    }

    public AbstractController getScript(HttpType type) {
        return map.get(type);
    }
}
