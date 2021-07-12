package com.dtarasiuk.module3;

import com.dtarasiuk.module3.repository.SkillRepository;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        SkillRepository skillRepository = new SkillRepository();
        skillRepository.readFromJsonFile();
        skillRepository.getAllSkillsInternal();

    }
}

