package com.dtarasiuk.module3;

import com.dtarasiuk.module3.model.Skill;
import com.dtarasiuk.module3.repository.DeveloperRepository;
import com.dtarasiuk.module3.repository.SkillRepository;
import com.dtarasiuk.module3.repository.TeamRepository;

import java.util.Scanner;

public class Terminal {

    public void run(){
        boolean start = true;
        System.out.println("App started:");
        System.out.println("Enter command: ");
        Scanner com = new Scanner(System.in);


        while (start){
            String command = com.nextLine();
            switch (command){
                //--------skills-----------
                case "add skill":
                    System.out.print("Enter new skill -> ");
                    Skill skill = new Skill();
                    SkillRepository addSkill = new SkillRepository();
                    Scanner scanner = new Scanner(System.in);
                    skill.setName(scanner.nextLine());
                    addSkill.save(skill);
                    System.out.println("----new skill added----");
                    break;
                case "rm skill":
                    SkillRepository rmSkill = new SkillRepository();
                    System.out.print("Enter skill's id you need to be deleted -> ");
                    Scanner rmId = new Scanner(System.in);
                    rmSkill.deleteById(rmId.nextLong());
                    System.out.println("skill removed");
                    break;
                case "get all skills":
                    SkillRepository getAll = new SkillRepository();
                    System.out.println("------all required skills-----");
                    getAll.getAll();
                    break;
                case "edit skill":
                    System.out.print("edit skill");
                    SkillRepository editSkill = new SkillRepository();
                    Skill editS = new Skill();
                    Scanner editScan = new Scanner(System.in);
                    System.out.println("Enter id of skill need to be updated");
                    editS.setId(editScan.nextLong());
                    System.out.println("enter new Skill name");
                    editS.setName(editScan.nextLine());
                    editSkill.update(editS);
                    break;
                //-----Teams-----
                case "create team":
                    System.out.println("");
                    //todo create team logic
                    break;
                case "get all teams":
                    TeamRepository getAllTeams = new TeamRepository();
                    System.out.println("-----All team requested-----");
                    getAllTeams.getAll();
                    break;
                case "rm team":
                    //todo remove team
                    break;
                case "update team":
                    // todo update
                    break;

                //-----Developers-----

                case "create dev":
                    //todo create developer
                    break;
                case "get all devs":
                    DeveloperRepository getallDevs = new DeveloperRepository();
                    System.out.println("-----All team requested-----");
                    //todo create getall method in Dev Repo
                    break;
                case "rm dev":
                    //todo remove developer
                    break;
                case "update dev":
                    // todo update developer
                    break;

                case "exit":
                    start=false;
                    break;
                default:
                    System.out.println("no such command:");
            }
        }
    }
}
