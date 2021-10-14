package com.xiexin.shirotest;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.jupiter.api.Test;

/*
* shiro 的加密 和 认证测试
* md5 加密 简单但是不可逆，但是可以根据加密后的密码 进行反推
* */
public class MyShiro {
    //shiro 有对 明文密码 123456 有加密的功能,让web的密码更加安全
    //更加安全 就需要加盐  salt
    @Test
    public  void testCmd5(){
        Md5Hash md5Hash =  new Md5Hash("123456"); //e10adc3949ba59abbe56e057f20f883e
        System.out.println("md5Hash = " + md5Hash);

        //给密码加盐 更安全
        Md5Hash md5Hash1 = new Md5Hash("123456", "xieshadouxing");
        System.out.println("md5Hash1 = " + md5Hash1);

        //给加盐后的密码 进行散列处理
        Md5Hash md5Hash2 = new Md5Hash("123456", "xieshadouxing", 1024);//社工 大数据!!!
        System.out.println("md5Hash2 = " + md5Hash2);
    }
}
