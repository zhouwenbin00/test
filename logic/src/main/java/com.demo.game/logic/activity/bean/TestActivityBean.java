package com.demo.game.logic.activity.bean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.demo.game.logic.activity.ActivityBean;

import java.util.Map;

/** @author zwb */
public class TestActivityBean extends ActivityBean {

    private Map<String, String> luckyNum;

    @Override
    public void parseJson() {
        JSONObject jsonObject = JSON.parseObject(this.getJson());
        JSONArray luckyNum = jsonObject.getJSONArray("luckyNum");
        for (int i = 0; i < luckyNum.size(); i++) {
            JSONObject temp = luckyNum.getJSONObject(i);
            this.luckyNum.put(temp.getString("num"), temp.getString("reward"));
        }
    }
}
