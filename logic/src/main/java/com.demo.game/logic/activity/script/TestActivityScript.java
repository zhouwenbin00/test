package com.demo.game.logic.activity.script;

import com.demo.game.logic.activity.ActivityManager;
import com.demo.game.logic.activity.ActivityScript;
import com.demo.game.logic.activity.ActivityType;
import com.demo.game.logic.activity.bean.TestActivityBean;
import com.google.inject.Inject;

/**
 * 测试活动
 *
 * @author zwb
 */
public class TestActivityScript extends ActivityScript<TestActivityBean> {

    @Inject
    protected TestActivityScript(ActivityManager activityManager) {
        super(activityManager);
    }

    @Override
    public TestActivityBean getBean() {
        return new TestActivityBean();
    }

    @Override
    protected void onOpen0(TestActivityBean testActivityBean) {}

    @Override
    protected void onClose0(TestActivityBean testActivityBean) {}

    @Override
    public ActivityType type() {
        return ActivityType.TEST;
    }
}
