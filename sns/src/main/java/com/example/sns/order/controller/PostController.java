package com.example.sns.order.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }
    @RequestMapping("/post")
    public String post() {
        return "post";
    }
}
