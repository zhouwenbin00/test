package com.demo.game.logic.activity;

import lombok.Data;

/**
 * 活动实体
 *
 * @author zwb
 */
@Data
public abstract class ActivityBean {

    /** 活动id */
    private int id;

    /** 活动名称 */
    private String name;

    /** 活动类型 */
    private ActivityType type;

    /** 开启时间 */
    private long openTime;

    /** 关闭时间 */
    private long endTime;

    /** 自定义json数据 */
    private String json;

    /** 活动每日重置 */
    private boolean resetDaily;

    /** 活动状态 */
    private ActivityStatue statue = ActivityStatue.NO_SATRT;

    /** 解析json数据 */
    public abstract void parseJson();
}
