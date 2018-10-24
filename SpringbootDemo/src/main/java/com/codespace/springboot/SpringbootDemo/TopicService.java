package com.codespace.springboot.SpringbootDemo;


import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    private List<Topic> topics= new ArrayList<> (Arrays.asList(
            new Topic("spring","spring framework","spring framework"),
            new Topic("java","java framework","java framework"),
            new Topic("javascript","javascript framework","javascript framework")
        )
    );

    public List<Topic> getAllTopics(){
        return topics;
    }

    public Topic getTopic(String id){

        Topic topic = topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
        return topic;

    }

    public void addTopic(Topic topic){

            topics.add(topic);
    }

}
