package com.demo.game;

import com.demo.core.net.HttpServer;
import com.demo.core.utils.EnumUtils;
import com.demo.game.logic.cmd.CmdManager;
import com.demo.game.logic.cmd.CmdType;
import com.demo.game.logic.http.handler.HttpServerHandler;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 启动器
 *
 * @author zwb
 */
@Singleton
@Slf4j
public class Launcher {

    private final CmdManager cmdManager;
    private HttpServer server;
    private final HttpServerHandler httpServerHandler;

    @Inject
    public Launcher(CmdManager cmdManager, HttpServerHandler httpServerHandler) {
        this.cmdManager = cmdManager;
        this.httpServerHandler = httpServerHandler;
    }

    public void run() {

        makeSureNoNull();
        runCmdListener();
        server = new HttpServer(9999, "gm服务器", httpServerHandler);
        server.start();
    }

    /** 检查是否存在空的脚本 */
    private void makeSureNoNull() {
        log.info("开始检查非空...");
        cmdManager.makeSureNoNull();
        log.info("检查非空结束...");
    }

    /** 开启cmd命令行监听 */
    private void runCmdListener() {
        log.info("开启命令行监听...");
        new Thread(
                        new Runnable() {
                            @Override
                            public void run() {
                                while (true) {
                                    Scanner sc = new Scanner(System.in);
                                    String str = sc.nextLine();
                                    String[] split = str.split(StringConstant.BLANK);
                                    String[] params = Arrays.copyOfRange(split, 1, split.length);
                                    CmdType cmdType =
                                            EnumUtils.getEnumByName(CmdType.class, split[0]);
                                    if (cmdType != null) {
                                        cmdManager.getScript(cmdType).action(params);
                                    }
                                }
                            }
                        })
                .start();
    }
}
