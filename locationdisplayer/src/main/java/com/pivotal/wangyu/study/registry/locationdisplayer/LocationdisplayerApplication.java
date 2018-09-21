package com.pivotal.wangyu.study.registry.locationdisplayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@SpringBootApplication
@RestController
public class LocationdisplayerApplication {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(LocationdisplayerApplication.class, args);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @RequestMapping("/where")
    public String foo() {
        URI uri = UriComponentsBuilder.fromUriString("//locationreporter/getlocation").build().toUri();
        Location location = restTemplate.getForObject(uri,Location.class);
        String result = String.format("<table><tr><th>Country</th><th>City</th><th>latitude</th><th>longitude</th></tr>" +
                "<tr><td>%s</td><td>%s</td><td>%d</td><td>%d</td></tr></table>",
                location.getCountry(),location.getCity(),location.getLatitude(),location.getLongitude());
        return result;
    }

}
