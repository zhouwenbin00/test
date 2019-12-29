package com.demo.game.logic.activity;

import lombok.extern.slf4j.Slf4j;

/** @author zwb */
@Slf4j
public abstract class ActivityScript<T extends ActivityBean> {

    private final ActivityManager activityManager;

    protected ActivityScript(ActivityManager activityManager) {
        this.activityManager = activityManager;
        this.activityManager.register(this);
    }

    public abstract T getBean();

    /** 活动开启时 */
    public void onOpen(T t) {
        log.info("活动开始, id:{} -------");
        onOpen0(t);
    }

    /**
     * 活动关闭时
     *
     * @param t
     */
    public void onClose(T t) {
        log.info("活动结束, id:{}----", t.getId());
        onClose0(t);
    }

    /**
     * 活动类型
     *
     * @return
     */
    public abstract ActivityType type();

    protected abstract void onOpen0(T t);

    protected abstract void onClose0(T t);
}
