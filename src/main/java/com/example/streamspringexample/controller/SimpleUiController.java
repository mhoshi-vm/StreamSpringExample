package com.example.streamspringexample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimpleUiController {

    @GetMapping("/")
    public String home(){
        return "stream";
    }
}
