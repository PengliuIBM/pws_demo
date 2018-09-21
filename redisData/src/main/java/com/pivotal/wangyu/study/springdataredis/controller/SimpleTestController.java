package com.pivotal.wangyu.study.springdataredis.controller;

import com.pivotal.wangyu.study.springdataredis.modle.Project;
import com.pivotal.wangyu.study.springdataredis.services.ProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/simpleTest")
public class SimpleTestController {

    @Autowired
    private ProjectsService myService;

    @GetMapping("/sayhello")
    public String sayHello() {
        return "it is works!";
    }


    @GetMapping("/getProjects")
    public List<Project> getAllProjects(){
        return myService.getAllProjects();
    }

}
