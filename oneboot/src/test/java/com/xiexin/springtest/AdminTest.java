package com.xiexin.springtest;
/*
* springboot 对dao 或者service一个测试
* 也是单元测试，在公司，你一要自己写完一个service dao 去测试一下
* */

import com.xiexin.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class) //@autuwrid可以用
@SpringBootTest //证明 可以启动boot
@EnableAutoConfiguration //开启 配置
public class AdminTest {
    @Autowired
    private AdminService adminService;
    @Test
    public void selectMore(){
        Map map=new HashMap();
        map.put("adminAccount","binbin");
        List<Map> maps = adminService.selectMore(map);
        System.out.println("maps = " + maps);
        for (Map map1 : maps) {
            System.out.println("map1.get(\"adminName\") = " + map1.get("adminName"));
        }
    }
}
