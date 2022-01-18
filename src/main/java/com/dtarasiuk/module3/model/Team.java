package com.dtarasiuk.module3.model;

import com.dtarasiuk.module3.TeamStatus;
import com.dtarasiuk.module3.model.Developer;

import java.util.List;

public class Team {
    private Long id;
    private String name;
    List<Developer> developers;
    private TeamStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(List<Developer> developers) {
        this.developers = developers;
    }

    public TeamStatus getStatus() {
        return status;
    }

    public void setStatus(TeamStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", developers=" + developers +
                ", status=" + status +
                '}';
    }
}
