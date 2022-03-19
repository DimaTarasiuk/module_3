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
                    break;
                case "upd skill":
                    System.out.print("updating skill...");
                    Scanner editScan = new Scanner(System.in);
                    Skill editskill = new Skill();
                    System.out.println("Enter ID of skill that should be updated");
                    editskill.setId(editScan.nextLong());
                    System.out.println("enter new Skill name");
                    editScan = new Scanner(System.in);
                    editskill.setName(editScan.nextLine());
                    skillRepository.update(editskill);
                    System.out.println("Skill with id:" + editskill.getId() + " has been updated");
                    break;
                case "get all skills":
                    System.out.println(skillRepository.getAll());
                    System.out.println(" ");
                    break;
                default:
                    System.out.println("no such command use CRUD operations");
            }
            System.out.println("Do you wanna continue? Y/N");
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine();
            isRun = answer.equals("y");
        }
    }


}
