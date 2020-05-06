package com.zwb.demo.gencode;

import com.zwb.demo.gencode.define.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class BootMain {

    public static void main(String[] args) {
        SpringApplication.run(BootMain.class);
        Main main =new Main();
        main.main();
    }
}
