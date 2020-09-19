package com.example.demo.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//访问html页面必须注解为Controller不能为RestController，否则无法访问
@Controller
public class TestController {
    /**
     * 本地访问内容地址: http://localhost:8080/hello
     * @param map
     * @return
     */
    @RequestMapping("/hello")
    public String helloHtml(HashMap<String, Object> map){
        map.put("hello", "听风就是雨");
        return "/index";
    }
}
