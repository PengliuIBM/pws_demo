package com.pivotal.wangyu.study.springdataredis.services;

import com.pivotal.wangyu.study.springdataredis.modle.Project;
import com.pivotal.wangyu.study.springdataredis.repo.ProjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectsService {

    @Autowired
    private RedisTemplate<String, Project> redisTemplate;


    @Autowired
    private ProjectsRepository repository;


    public List<Project> getAllProjects() {
        List<Project> result = new ArrayList<Project>();
        repository.findAll().forEach(project -> result.add(project));
        return result;
    }





}
