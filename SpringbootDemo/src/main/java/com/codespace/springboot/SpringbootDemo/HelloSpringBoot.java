package com.codespace.springboot.SpringbootDemo;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSpringBoot {

    @RequestMapping("/index")
    public String index(){
        return "hello SpringBoot!";
    }
}
