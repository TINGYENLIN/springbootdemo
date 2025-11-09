package com.example.demo.testcontriller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
public class testcontroller {

    @RequestMapping("/test")
    public String test() {
        System.out.println("Hi");
        return "Hollo World!";
    }


}
