package com.dtarasiuk.module3;

import com.dtarasiuk.module3.model.Skill;
import com.dtarasiuk.module3.repository.DeveloperRepository;
import com.dtarasiuk.module3.repository.SkillRepository;
import com.dtarasiuk.module3.repository.TeamRepository;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Terminal terminal = new Terminal();
        terminal.run();
    }
}