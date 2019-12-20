package com.test.demo;

import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.management.ManagementFactory;

/**
 * @author zwb
 */
public class MyTest {


    /**
     * 获取当前用户文件夹
     */
    @Test
    public void test0(){
        System.out.println(System.getProperty("user.dir"));
    }

    /**
     * 获取当前运行的进程id
     */
    @Test
    public void test1(){
        String runtimeName;
        System.out.println(runtimeName = ManagementFactory.getRuntimeMXBean().getName());
        String pid;
        pid = runtimeName.split("@")[0];
        System.out.println("进程id是:" + pid);

        try {
            FileWriter fileWriter = new FileWriter("server.pid");
            fileWriter.write(pid);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
