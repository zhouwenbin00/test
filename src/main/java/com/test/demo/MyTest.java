package com.test.demo;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Test
    public void test2(){
        int a = 1;
        method1(a);
        System.out.println(a);
        System.out.println("----------");
        Integer b = 1;
        method2(b);
        System.out.println(b);
        System.out.println("----------");
        String c = "zzzz";
        method3(c);
        System.out.println(c);
        System.out.println("----------");
        String d = new String("zzzz");
        method4(d);
        System.out.println(d);
        System.out.println("----------");
        List e = new ArrayList();
        method5(e);
        System.out.println(e);
        System.out.println("----------");
        JSONObject f = new JSONObject();
        method6(f);
        System.out.println(f.toJSONString());
        System.out.println("----------");
        JSONObject[] g = new JSONObject[2];
        method7(g);
        System.out.println(Arrays.toString(g));
        System.out.println("----------");
        x x = new x("1");
        method8(x);
        System.out.println(x.s);
    }

    private void method8(x x) {
        x= new x("2");
    }

    final class x{
        private String s ;

        public x(String s) {
            this.s = s;
        }
    }

    private void method7(JSONObject[] g) {
        g[0] = new JSONObject();
    }

    private void method6(JSONObject f) {
        f.put("1",1);
    }

    private void method5(List e) {
        e.add(1);
    }

    private void method4(String d) {
        d = new String("cccc");
    }

    private void method3(String c) {
        c ="sss";
    }

    public void method1(int a){
        a=2;
    }

    public void method2(Integer a){
        a=2;
    }

}
