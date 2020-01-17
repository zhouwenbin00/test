package com.test.demo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zwb
 */
public class Mytest1 {
    public static void main(String[] args) {
//        Achievement.ResStateChange defaultInstance = Achievement.ResStateChange.getDefaultInstance();
//        System.out.println(defaultInstance.getMsgId());
    }

    @Test
    public void test1(){
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,4));
        List<Integer> list2 =new ArrayList<>( Arrays.asList(1,2,5,6));
        list1.retainAll(list2);
        System.out.println(list1);
    }
}
