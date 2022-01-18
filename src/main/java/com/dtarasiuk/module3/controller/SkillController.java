package com.dtarasiuk.module3.controller;

import com.dtarasiuk.module3.model.Skill;
import com.dtarasiuk.module3.repository.ISkillRepository;
import com.dtarasiuk.module3.repository.gson.GsonSkillRepositoryImpl;

import java.util.List;

public class SkillController {
    private final ISkillRepository skillRepository = new GsonSkillRepositoryImpl();

    public Skill createSkill(String name){
        Skill skill = new Skill();
        skill.setName(name);
        return skillRepository.save(skill);
    }

    public Skill updateSkill(Long id){
        Skill skill = new Skill();
        skillRepository.update(skill);
        return skillRepository.save(skill);
    }
}
