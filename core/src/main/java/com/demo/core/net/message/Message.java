package com.demo.core.net.message;

/**
 * 抽象消息类
 *
 * @author zwb
 */
public abstract class Message<T extends Message> {

    public abstract void write();

    public abstract T read();
}
