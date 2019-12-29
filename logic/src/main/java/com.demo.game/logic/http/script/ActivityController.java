package com.demo.game.logic.http.script;

import com.demo.game.logic.activity.ActivityBean;
import com.demo.game.logic.activity.ActivityManager;
import com.demo.game.logic.http.AbstractController;
import com.demo.game.logic.http.HttpControllerManager;
import com.demo.game.logic.http.HttpType;
import com.demo.game.logic.http.request.Request;
import com.demo.game.logic.http.response.Response;
import com.demo.game.logic.http.response.ResponseResult;
import com.google.inject.Inject;

import java.util.List;
import java.util.Map;

/**
 * 添加活动
 *
 * @author zwb
 */
public class ActivityController extends AbstractController {

    private final ActivityManager activityManager;

    @Inject
    protected ActivityController(
            HttpControllerManager httpControllerManager, ActivityManager activityManager) {
        super(httpControllerManager);
        this.activityManager = activityManager;
    }

    @Override
    public HttpType type() {
        return HttpType.ADD_ACTIVITY;
    }

    @Override
    public Response exec(Request request) {
        Map<String, List<String>> params = request.getParams();
        String data = params.get("data").get(0);
        ActivityBean activityBean = activityManager.create(data);
        if (activityBean == null){
            return ResponseResult.fail("构建活动实体失败, " +
                    "不存在的活动类型");
        }
        activityManager.addActivityBean(activityBean.getId(), activityBean);
        return ResponseResult.ok();
    }
}
