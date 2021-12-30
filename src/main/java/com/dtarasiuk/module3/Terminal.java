package com.dtarasiuk.module3;

import com.dtarasiuk.module3.model.Developer;
import com.dtarasiuk.module3.model.Skill;
import com.dtarasiuk.module3.model.Team;
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
                case "update skill":
                    System.out.print("updating skill...");
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
                case "add team":
                    System.out.println("Enter the name of new team ->");
                    Team team = new Team();
                    TeamRepository newTeam = new TeamRepository();
                    Scanner userInputTeam = new Scanner(System.in);
                    team.setName(userInputTeam.nextLine());
                    newTeam.save(team);
                    break;
                case "get all teams":
                    TeamRepository getAllTeams = new TeamRepository();
                    System.out.println("-----All team requested-----");
                    getAllTeams.getAll();
                    break;
                case "rm team":
                    TeamRepository rmTeam = new TeamRepository();
                    System.out.println("Enter team ID need to be removed ->");
                    Scanner rmTeamID = new Scanner(System.in);
                    rmTeam.deleteById(rmTeamID.nextLong());
                    System.out.println("Team with your ID removed");
                    break;
                case "update team":
                    System.out.print("updating skill...");
                    TeamRepository editTeam = new TeamRepository();
                    Team editT = new Team();
                    Scanner editTeamScan = new Scanner(System.in);
                    System.out.println("Enter id of skill need to be updated");
                    editT.setId(editTeamScan.nextLong());
                    System.out.println("enter new Skill name");
                    editT.setName(editTeamScan.nextLine());
                    editTeam.update(editT);
                    break;

                //-----Developers-----

                case "add dev":
                    System.out.print("Enter new skill -> ");
                    Developer developer = new Developer();
                    DeveloperRepository addDev = new DeveloperRepository();
                    Scanner addDevScan = new Scanner(System.in);
                    System.out.println("Enter developer name -> ");
                    developer.setFirstName(addDevScan.nextLine());
                    System.out.println("Enter developer last name -> ");
                    developer.setLastName(addDevScan.nextLine());
                    System.out.println("Add developer skill -> ");
                    addDev.save(developer);
                    System.out.println("----new developer added----");
                    break;
                case "get all devs":
                    DeveloperRepository getAllDevs = new DeveloperRepository();
                    System.out.println("-----All developers requested-----");
                    getAllDevs.getAll();
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
