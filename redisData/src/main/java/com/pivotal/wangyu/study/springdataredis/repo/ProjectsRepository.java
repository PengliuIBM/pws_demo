package com.pivotal.wangyu.study.springdataredis.repo;

import com.pivotal.wangyu.study.springdataredis.modle.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectsRepository extends CrudRepository<Project, String> {
}

