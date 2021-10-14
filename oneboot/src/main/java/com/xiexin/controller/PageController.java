package com.xiexin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageController {  // /page/studentlist
    @RequestMapping("/studentlist")
    public String studentlist(){
        return "studentlist";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/regin")
    public String regin(){
        return "regin";
    }


    @RequestMapping("/shriologin")
    public String shriologin(){
        return "shriologin";
    }


    @RequestMapping("/shrioregin")
    public String shrioregin(){
        return "shrioregin";
    }


    @RequestMapping("/reg")
    public String reg(){
        return "reg";
    }

}
