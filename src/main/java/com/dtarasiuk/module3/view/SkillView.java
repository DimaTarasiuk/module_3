package com.dtarasiuk.module3.view;

import com.dtarasiuk.module3.model.Skill;
import com.dtarasiuk.module3.repository.ISkillRepository;
import com.dtarasiuk.module3.repository.gson.GsonSkillRepositoryImpl;
import com.dtarasiuk.module3.repository.tmpRepo.SkillRepository;

import java.util.Scanner;

public class SkillView {
    private boolean isRun = true;
    private final ISkillRepository skillRepository = new GsonSkillRepositoryImpl();

    public void runView(){
        while (isRun){
            System.out.println("App started:");
            System.out.println("Enter command: ");
            Scanner com = new Scanner(System.in);
            String command = com.nextLine();
            switch (command){
                case "add skill":
                    System.out.print("Enter new skill -> ");
                    Skill skill = new Skill();
                    Scanner scanner = new Scanner(System.in);
                    skill.setName(scanner.nextLine());
                    skillRepository.save(skill);
                    System.out.println("----new skill added----");
                    break;
                case "rm skill":
                    System.out.println("Enter ID of skill you want to remove ->");
                    scanner = new Scanner(System.in);
                    skillRepository.deleteById(scanner.nextLong());
                    System.out.println("skill with id " + scanner + "removed");
            }
            System.out.println("Do you wanna continue? Y/N");
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine();
            if (answer == "y")
                isRun = true;
            else isRun = false;
        }
    }


}
