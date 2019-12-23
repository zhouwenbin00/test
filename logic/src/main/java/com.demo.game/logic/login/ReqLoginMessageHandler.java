package com.demo.game.logic.login;

import com.demo.game.MessageHandler;
import com.demo.game.login.ReqLoginMessage;
import com.demo.game.user.User;
import com.google.inject.Singleton;

/** @author zwb */
@Singleton
public class ReqLoginMessageHandler implements MessageHandler<ReqLoginMessage> {

    @Override
    public void exec(User user, ReqLoginMessage message) {
        System.out.println("登陆请求");
    }
}
