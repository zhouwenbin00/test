package com.demo.game.logic.activity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.demo.core.lang.EnumArray;
import com.demo.game.logic.event.EventListener;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * 活动管理
 *
 * @author zwb
 */
@Slf4j
public class ActivityManager implements EventListener.ServerTick {

    /** 活动脚本容器, type->script */
    private final EnumArray<ActivityType, ActivityScript> scripts =
            new EnumArray<>(ActivityType.class);
    /** 活动容器, id->bean */
    private final Map<Integer, ActivityBean> activityMap = new HashMap<>();

    /**
     * 注册脚本
     *
     * @param script
     */
    public void register(ActivityScript script) {
        this.scripts.set(script.type(), script);
    }

    /**
     * 获取脚本
     *
     * @param type
     * @return
     */
    public ActivityScript getScript(ActivityType type) {
        return scripts.get(type);
    }

    /**
     * 获取活动实体
     *
     * @param id
     * @return
     */
    public ActivityBean getActivityBean(int id) {
        return activityMap.get(id);
    }

    /**
     * 添加活动实体
     *
     * @param id
     * @param activityBean
     */
    public void addActivityBean(int id, ActivityBean activityBean) {
        if (this.activityMap.containsKey(id)) {
            log.info("已经存在的活动id:{},执行替换");
        }
        this.activityMap.put(id, activityBean);
    }

    /**
     * 创建活动实体
     *
     * @param json
     * @return
     */
    public ActivityBean create(String json) {
        JSONObject jsonObject = JSON.parseObject(json);
        ActivityType type = ActivityType.valueOf(jsonObject.getIntValue("type"));
        if (type == null){
            return null;
        }
        ActivityScript script = getScript(type);
        ActivityBean bean = script.getBean();
        bean.setType(type);
        bean.setId(jsonObject.getIntValue("id"));
        bean.setName(jsonObject.getString("name"));
        bean.setOpenTime(jsonObject.getLongValue("openTime"));
        bean.setEndTime(jsonObject.getLongValue("endTime"));
        bean.setJson(jsonObject.getString("json"));
        bean.setResetDaily(jsonObject.getBoolean("resetDaily"));
        bean.parseJson();
        return bean;
    }

    private void activityBeanTick(long now) {
        Set<Integer> removes = new HashSet<>();
        this.activityMap.forEach(
                (k, v) -> {
                    if (now >= v.getEndTime()) {
                        removes.add(k);
                    }

                    if (v.getStatue() == ActivityStatue.NO_SATRT && now >= v.getOpenTime()) {
                        ActivityScript script = getScript(v.getType());
                        script.onOpen(v);
                    }
                });

        if (removes.size() > 0) {
            for (Integer id : removes) {
                ActivityBean activityBean = this.activityMap.get(id);
                ActivityScript script = getScript(activityBean.getType());
                script.onClose(activityBean);
                this.activityMap.remove(id);
            }
        }
    }

    @Override
    public void onServerTick(long now) {
        this.activityBeanTick(now);
    }
}
