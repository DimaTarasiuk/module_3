package com.dtarasiuk.module3;

import com.dtarasiuk.module3.view.DeveloperView;
import com.dtarasiuk.module3.view.SkillView;

public class Main {
    public static void main(String[] args) {
        System.out.println("App started:");
        System.out.println("Enter command:");

        SkillView skillView = new SkillView();
        skillView.runView();

        //DeveloperView developerView = new DeveloperView();
        //developerView.runView();
    }
}