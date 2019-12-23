package com.demo.game;

import com.demo.core.net.message.Message;
import com.demo.game.user.User;

/**
 * 消息处理器
 *
 * @author zwb
 */
public interface MessageHandler<T extends Message> {

    /**
     * 处理消息
     *
     * @param user 用户
     * @param message 消息
     */
    public void exec(User user, T message);
}
