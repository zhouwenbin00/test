package com.demo.game.logic.cmd;

import com.demo.core.lang.EnumArray;
import com.google.inject.Singleton;

/** @author zwb */
@Singleton
public class CmdManager {

    private final EnumArray<CmdType, CmdScript> scripts = new EnumArray<>(CmdType.class);

    public void makeSureNoNull() {
        scripts.makeSureNoNull();
    }

    public CmdScript getScript(CmdType type) {
        return scripts.get(type);
    }

    public void register(CmdScript script) {
        scripts.set(script.type(), script);
    }
}
