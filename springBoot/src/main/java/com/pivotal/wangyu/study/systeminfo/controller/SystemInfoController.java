package com.pivotal.wangyu.study.systeminfo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping("/system")
public class SystemInfoController {

    @GetMapping("info")
    public String getIP() throws UnknownHostException {
        InetAddress ip =null;
        ip = InetAddress.getLocalHost();

        return "Get Information from IP: <h1>"+ip.getHostAddress()+"</h1>";
    }

    @GetMapping("killme")
    public void killme(){
        System.exit(0);
    }
}
