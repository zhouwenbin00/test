package com.demo.game.logic.cmd.script;

import com.demo.game.logic.cmd.CmdManager;
import com.demo.game.logic.cmd.CmdScript;
import com.demo.game.logic.cmd.CmdType;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/** @author zwb */
@Singleton
public class StopCmdScript extends CmdScript {

    @Inject
    protected StopCmdScript(CmdManager cmdManager) {
        super(cmdManager);
    }

    @Override
    public CmdType type() {
        return CmdType.STOP;
    }

    @Override
    public void action0(String... params) {
        System.exit(0);
    }
}
