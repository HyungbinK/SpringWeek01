package com.spring.springweek01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/api/boards/detail")
    public String detailBlog(@RequestParam("id") Long id) {
        return "/detail.html";
    }
}
