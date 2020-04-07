package com.test.demo;

import cn.hutool.core.bean.BeanUtil;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** @author zwb */
public class Mytest1 {
    public static void main(String[] args) {
        //        Achievement.ResStateChange defaultInstance =
        // Achievement.ResStateChange.getDefaultInstance();
        //        System.out.println(defaultInstance.getMsgId());
    }

    @Test
    public void test1() {
        //        List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,4));
        //        List<Integer> list2 =new ArrayList<>( Arrays.asList(1,2,5,6));
        //        list1.retainAll(list2);
        //        System.out.println(list1);
        //        BeanUtils.copyProperties();
    }

    @Test
    public void test2() throws IOException {
        String dir = "C:\\Users\\mshz\\Desktop\\s1";
        File file = new File(dir);
        for (File file1 : file.listFiles()) {
            if (file1.isDirectory()) {
                continue;
            }
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file1));
            BufferedReader br = new BufferedReader(reader);
            String s = null;
            while ((s = br.readLine()) != null) {
                if (s.contains("ERROR") && s.contains("ArenaManager")) {
                    System.out.println(file1.getName() + "---" + s);
                }
            }
        }
    }

    @Test
    public void test3() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        boolean a = list.stream().peek(System.out::println).allMatch(i -> i > 3);
        System.out.println(a);
        System.out.println("-------------------------------");

        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5, 6);
        list2.forEach(System.out::println);
        boolean b = list2.stream().allMatch(i -> i > 3);
        System.out.println(b);

    }
}
