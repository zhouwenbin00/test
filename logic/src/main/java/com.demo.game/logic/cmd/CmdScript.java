package com.demo.game.logic.cmd;

public abstract class CmdScript {

    private final CmdManager cmdManager;

    protected CmdScript(CmdManager cmdManager) {
        this.cmdManager = cmdManager;
        cmdManager.register(this);
    }

    public void action(String... params) {
        action0(params);
    }

    public abstract CmdType type();

    public abstract void action0(String... params);
}
