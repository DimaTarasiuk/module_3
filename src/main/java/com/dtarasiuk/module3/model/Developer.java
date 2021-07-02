package com.dtarasiuk.module3.model;

import java.util.List;

public class Developer {
    private Long developerId;
    private String firstName;
    private String LastName;
    private List<Skill> skillList;

    public Long getDeveloperId(){
        return developerId;
    }

    public void setDeveloperId(Long developerId){
        this.developerId = developerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public List<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }

    @Override
    public String toString() {
        return "Developer{" + "firstName='" + firstName + '\'' + ", LastName='" + LastName + '\'' + ", skillList=" + skillList + '\'' + ", developerId='" + developerId + '}';
    }
}
