package com.demo.game.logic.http.script;

import com.demo.game.logic.http.AbstractController;
import com.demo.game.logic.http.HttpControllerManager;
import com.demo.game.logic.http.HttpType;
import com.demo.game.logic.http.request.Request;
import com.demo.game.logic.http.response.Response;
import com.demo.game.logic.http.response.ResponseResult;
import com.demo.game.logic.http.response.Result;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** @author zwb */
@Singleton
public class GmController extends AbstractController {

    @Inject
    protected GmController(HttpControllerManager httpControllerManager) {
        super(httpControllerManager);
    }

    @Override
    public HttpType type() {
        return HttpType.GM;
    }


    @Override
    public Response exec(Request request) {
        Map<String, List<String>> params = request.getParams();
        List<String> gm = params.get("gm");
        List<String> params1 = params.get("params");
        System.out.println(gm);
        System.out.println(params1);
        ArrayList<Integer> objects = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            objects.add(i);
        }
        Result<Integer> result = new Result<>(objects.size(), objects);
        return ResponseResult.ok().boby(result);
    }
}
