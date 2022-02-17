package com.dtarasiuk.module3.controller;

import com.dtarasiuk.module3.model.Developer;
import com.dtarasiuk.module3.model.Skill;
import com.dtarasiuk.module3.repository.ISkillRepository;
import com.dtarasiuk.module3.repository.gson.GsonSkillRepositoryImpl;

import java.util.List;

public class SkillController {
    private final ISkillRepository skillRepository = new GsonSkillRepositoryImpl();

    public Skill createSkill(Long id, String name){
        Skill skill = new Skill();
        skill.setId(id);
        skill.setName(name);
        return skillRepository.save(skill);
    }

    public Skill updateSkill(Long id, String name){
        Skill skill = new Skill();
        skill.setId(id);
        skill.setName(name);
        skillRepository.update(skill);
        return skillRepository.save(skill);
    }

    public void deleteSkill(Long id){
        skillRepository.deleteById(id);
    }

}
