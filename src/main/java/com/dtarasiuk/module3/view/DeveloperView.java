package com.dtarasiuk.module3.view;

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

                    break;
                case "rm dev":
                    System.out.println("Enter Id of Dev you want to remove");
                    developerRepository.deleteById(scanner.nextLong());
                    break;
                case "upd dev":

                    break;
                case "get dev":
                    developerRepository.getAll();
                    break;
            }
        }

    }
}
