package com.demo.game.logic.http;

import com.demo.game.logic.activity.ActivityType;

/** @author zwb */
public enum HttpType {

    /** gm */
    GM("/commands"),

    /** 添加活动 */
    ADD_ACTIVITY("/addActivity"),
    ;
    private final String url;

    HttpType(String url) {
        this.url = url;
    }



    public static HttpType create(String url) {
        for (HttpType httpType : values()) {
            if (httpType.getUrl().equals(url)){
                return httpType;
            }
        }
        return null;
    }

    public String getUrl() {
        return url;
    }
}
