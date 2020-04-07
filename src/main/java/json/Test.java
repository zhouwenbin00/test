package json;

import com.alibaba.fastjson.JSON;

import java.io.PipedWriter;
import java.util.Base64;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zwb
 */
public class Test {

   static class Student{
       private int fuck;
       private int age;
       private String name;
       private final Set<Integer> clzz = new HashSet<>();

       public Student(int fuck) {
           this.fuck = fuck;
       }

       public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Set<Integer> getClzz() {
            return clzz;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    ", clzz=" + clzz +
                    '}';
        }
    }

    @org.junit.Test
    public void test(){
        Student student = new Student(1);
        student.age = 1;
        student.name = "李四";
        student.clzz.add(1);
        student.clzz.add(2);
        String s = JSON.toJSONString(student);
        System.out.println(s);
        Student student1 = JSON.parseObject(s, Student.class);
        System.out.println(student1);
    }

    @org.junit.Test
    public void name() {
        long score = 99999;
        long score2 = 99999;
        long time1 = 1;
        long time2 = 23456;
        long pow = (long) Math.pow(10, String.valueOf(time2).length());

        System.out.println(pow);
        double i = score * pow + time1;
        System.out.println(i);
        double j = score * pow + time2;
        System.out.println(j);
        System.out.println(i>j);

        System.out.println(i/100000);
    }

    public String ss(int x){
        String sscore = Integer.toBinaryString(x);
        double pow = Math.pow(10, 14);
        System.out.println(pow);
        return "";
    }

    @org.junit.Test
    public void json(){

    }


}
