package com.xiexin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//springboot是为了简化 ssm项目而存在的
//ssm 项目配置比较繁琐，比如，需要配置 tomcat ，需要有多个 xml 去配置 第三方依赖
//而springboot简化成，该内置的就内置，多个xml配置改为一个 properties / xml文件
//说白了还是ssm框架!!!只不过写起来简单了。
@SpringBootApplication  //springboot应用注解，标记 本项目是springboot项目，必须有这个注解！！！
@MapperScan("com.xiexin.dao") //持久层的dao 包扫描
public class SmartfoodApplication {
      //main方法 ，项目一启动就会执行该方法
    public static void main(String[] args) {
        //静态的调用 SpringApplication应用，参数为 本项目的启动类
        System.out.println("springboot 项目 启动啦......");
        SpringApplication.run(SmartfoodApplication.class, args);
    }

}
