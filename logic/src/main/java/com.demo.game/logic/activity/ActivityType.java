package com.demo.game.logic.activity;

/**
 * 活动类型
 *
 * @author zwb
 */
public enum ActivityType {
    /** 测试活动 */
    TEST(1),
    ;

    private final int type;

    ActivityType(int type) {
        this.type = type;
    }

    public static ActivityType valueOf(int type) {
        for (ActivityType activityType : values()) {
            if (activityType.type == type) {
                return activityType;
            }
        }
        return null;
    }
}
