package com.dtarasiuk.module3;

import com.dtarasiuk.module3.model.Skill;
import com.dtarasiuk.module3.repository.DeveloperRepository;
import com.dtarasiuk.module3.repository.SkillRepository;
import com.dtarasiuk.module3.repository.TeamRepository;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        SkillRepository sr = new SkillRepository();
        DeveloperRepository dr = new DeveloperRepository();
        TeamRepository tr = new TeamRepository();

        System.out.println("developers is " + dr.readFromJsonFile());
        System.out.println("team is " + tr.readFromJsonFile());
        System.out.println("======================");
        dr.getAllDevelopersInternal();
        System.out.println("generated id expected 4 - " + dr.generateId());
        sr.getAllSkillsInternal();
    }
}

