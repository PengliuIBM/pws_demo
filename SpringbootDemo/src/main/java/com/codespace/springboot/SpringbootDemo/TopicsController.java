package com.codespace.springboot.SpringbootDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */

@RestController
public class TopicsController {


    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics")
    public List<Topic> getTopics(){
        return topicService.getAllTopics();
    }

    @RequestMapping ("/topics/{topicid}")
    public Topic getTopic(@PathVariable("topicid") String id){
        System.out.println("id = " + id);
        return topicService.getTopic(id);
    }

    @RequestMapping (method = RequestMethod.POST, value = "/topics")
    public void addTopic(@RequestBody Topic topic){
        System.out.println("add topic: " + topic.getId());
            topicService.addTopic(topic);
    }

}
