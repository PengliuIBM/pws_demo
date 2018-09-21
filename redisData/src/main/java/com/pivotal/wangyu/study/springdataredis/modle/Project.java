package com.pivotal.wangyu.study.springdataredis.modle;


import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.Objects;

@RedisHash("Projects")

public class Project implements Serializable {
    @Id
    private String projectID;
    private String projectName;
    private String owner;
    private String des;

    public Project(String projectID, String projectName, String owner, String des) {
        this.projectID = projectID;
        this.projectName = projectName;
        this.owner = owner;
        this.des = des;
    }

    public String getProjectID() {
        return projectID;
    }

    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Project)) return false;
        Project project = (Project) o;
        return Objects.equals(getProjectID(), project.getProjectID()) &&
                Objects.equals(getProjectName(), project.getProjectName()) &&
                Objects.equals(getOwner(), project.getOwner()) &&
                Objects.equals(getDes(), project.getDes());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getProjectID(), getProjectName(), getOwner(), getDes());
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectID='" + projectID + '\'' +
                ", projectName='" + projectName + '\'' +
                ", owner='" + owner + '\'' +
                ", des='" + des + '\'' +
                '}';
    }

    public Project() {
    }

}

