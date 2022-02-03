package com.dtarasiuk.module3.controller;

import com.dtarasiuk.module3.model.Developer;
import com.dtarasiuk.module3.model.Skill;
import com.dtarasiuk.module3.repository.IDeveloperRepository;
import com.dtarasiuk.module3.repository.gson.GsonDeveloperRepositoryImpl;

import java.util.List;

public class DeveloperController {
    private final IDeveloperRepository developerRepository = new GsonDeveloperRepositoryImpl();

    public Developer createDeveloper(String firstName, String lastName, List<Skill> skills){
        Developer developer = new Developer();
        developer.setFirstName(firstName);
        developer.setLastName(lastName);
        developer.setSkillList(skills);
        return developerRepository.save(developer);
    }
    public Developer updateDeveloper(Long id,String firstName, String lastName, List<Skill> skills){
        Developer developer = new Developer();
        developer.setId(id);
        developer.setFirstName(firstName);
        developer.setLastName(lastName);
        developer.setSkillList(skills);
        developerRepository.update(developer);
        return developer;

































    }


}
