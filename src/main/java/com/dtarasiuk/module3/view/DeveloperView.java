package com.dtarasiuk.module3.view;

import com.dtarasiuk.module3.controller.DeveloperController;
import com.dtarasiuk.module3.model.Developer;
import com.dtarasiuk.module3.model.Skill;
import com.dtarasiuk.module3.repository.IDeveloperRepository;
import com.dtarasiuk.module3.repository.gson.GsonDeveloperRepositoryImpl;

import java.util.Scanner;

public class DeveloperView {
    private boolean isRun = true;
    private final IDeveloperRepository developerRepository = new GsonDeveloperRepositoryImpl();

    public void runView(){
        while (isRun){
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();

            switch (command){
                case "add dev":
                    Developer developer = new Developer();
                    DeveloperController developerController = new DeveloperController();
                    System.out.println("enter developer's first name: ");
                    Scanner sn = new Scanner(System.in);
                    String name = sn.nextLine();
                    String surname = sn.nextLine();
                    developerController.createDeveloper(name,surname,null);
                    System.out.println("----new developer added----");
                    break;
                case "rm dev":
                    System.out.println("Enter Id of Dev you want to remove");
                    developerRepository.deleteById(scanner.nextLong());
                    System.out.println("Developer with entered id was removed");
                    break;
                case "upd dev":

                    break;
                case "get dev":
                    developerRepository.getAll();
                    break;
                default:
                    System.out.println("No such crud command");
            }
            System.out.println("Do you wanna continue? Y/N");
            scanner = new Scanner(System.in);
            String answer = scanner.nextLine();
            isRun = answer.equals("y");
        }

    }
}
