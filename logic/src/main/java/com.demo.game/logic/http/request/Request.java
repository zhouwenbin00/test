package com.demo.game.logic.http.request;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 请求体
 *
 * @author zwb
 */
@Data
public class Request {

    private final String url;
    private final String uri;
    private final Map<String, List<String>> params;


}
