package com.test.demo;

public class GlobaUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(e.getMessage());
    }
}
