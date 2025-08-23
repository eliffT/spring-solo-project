package com.elif.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class HelloController {

    @GetMapping("/hello")
    public String Hello() {
        return "Hello, Spring Boot!";
    }
}
