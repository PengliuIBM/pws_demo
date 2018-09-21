package com.pivotal.wangyu.study.registry.locationreporter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class LocationreporterApplication {
    public static void main(String[] args) {
        SpringApplication.run(LocationreporterApplication.class, args);
    }
}

