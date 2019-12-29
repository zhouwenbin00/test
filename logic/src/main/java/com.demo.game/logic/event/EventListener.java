package com.demo.game.logic.event;

import com.demo.game.user.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

/** @author zwb */
public class EventListener {


    private final Map<Class<?> , Set<Object> > instances = new HashMap<>();

//    public <T> void post(Class<T> clazz, Consumer<> action){
//        for (Object instance : instances.get(clazz)) {
//            action.accept(instance);
//        }
//    }

    /**
     * 跨天
     */
    public interface OnDayEnd {
        void onDayEnd(User user);
    }

    /** 服务器定时器任务 */
    public interface ServerTick {
        void onServerTick(long now);
    }

//    public static void main(String[] args) {
//        EventListener eventListener =new EventListener();
//        eventListener.post(ServerTick.class, l->l.on);
//    }
}
