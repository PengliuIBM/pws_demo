package com.pivotal.wangyu.study.registry.locationreporter;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @RequestMapping("/getlocation")
    public Location getLocation(){
        return new Location("China","BeiJing",1254342,8663543);
    }


}

