package com.demo.game.logic.cmd.script;

import com.demo.game.Main;
import com.demo.game.logic.cmd.CmdManager;
import com.demo.game.logic.cmd.CmdScript;
import com.demo.game.logic.cmd.CmdType;
import com.google.inject.Inject;

/**
 * @author zwb
 */
public class JarCmdScript extends CmdScript {


    @Inject
    protected JarCmdScript(CmdManager cmdManager) {
        super(cmdManager);
    }

    @Override
    public CmdType type() {
        return CmdType.JAR;
    }

    @Override
    public void action0(String... params) {
        try {
            Main.main((String[]) null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
