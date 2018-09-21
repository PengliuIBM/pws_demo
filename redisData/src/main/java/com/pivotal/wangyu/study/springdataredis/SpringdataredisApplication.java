package com.pivotal.wangyu.study.springdataredis;

import com.pivotal.wangyu.study.springdataredis.modle.Project;
import com.pivotal.wangyu.study.springdataredis.repo.ProjectsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.stream.Stream;

@SpringBootApplication
public class SpringdataredisApplication {

    @Bean
    CommandLineRunner projects(ProjectsRepository projectRepository) {
        return
            args -> {
            projectRepository.deleteAll();
            Stream.of(new Project("pid0001","huawei","wangyu","this is a poc project."),
                    new Project("pid0002","picc","wangyu","this is a poc project."),
                    new Project("pid0003","neusoft","wangyu","this is a poc project."),
                    new Project("pid0004","ibm","wangyu","this is a poc project."))
            .forEach(project -> {
                projectRepository.save(project);
                System.out.println(project);
            });

        };
    }


        @Bean
        CommandLineRunner initCommand(RedisTemplate<String, Project> redisTemplate) {
                return
                    args -> {
                        Project p1 =new Project("wy001","picc","wangyu","this is a poc project.");
                        Project p2 =new Project("wy002","picc","wangyu","this is a poc project.");
                        Project p3 =new Project("wy003","picc","wangyu","this is a poc project.");
                        Project p4 =new Project("wy004","picc","wangyu","this is a poc project.");

                        redisTemplate.opsForList().leftPush("wzl",p1);
                        redisTemplate.opsForList().leftPush("wzl",p2);
                        redisTemplate.opsForList().leftPush("wzl",p3);
                        redisTemplate.opsForList().leftPush("wzl",p4);
                        Project gett = redisTemplate.opsForList().leftPop("wzl");
                        System.out.println(gett);
                    };
            }

    public static void main(String[] args) {
        SpringApplication.run(SpringdataredisApplication.class, args);
    }
}


