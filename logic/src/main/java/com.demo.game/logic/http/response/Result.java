package com.demo.game.logic.http.response;

import lombok.Data;

import java.util.List;

/**
 * 结果集
 *
 * @author zwb
 * @param <T>
 */
@Data
public class Result<T> {

    private final int total;
    private final List<T> result;

    public Result(int total, List<T> result) {
        this.total = total;
        this.result = result;
    }
}
