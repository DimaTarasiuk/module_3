package com.dtarasiuk.module3.repository;

import com.dtarasiuk.module3.model.Developer;
import com.dtarasiuk.module3.model.Skill;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DeveloperRepository {
    public String readFromJsonFile() {
        String pathToTheFle = "C:\\Users\\dtarasiuk\\IdeaProjects\\module_3\\src\\main\\resources\\developers.json";
        String developersAsString = null;
        List<Developer> developers = new ArrayList<>();

        try {
            File input = new File(pathToTheFle);
            JsonElement devElements = JsonParser.parseReader(new FileReader(input));
            JsonArray fileObject = devElements.getAsJsonArray();
            developersAsString = fileObject.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return developersAsString;
}
    public List<Developer> getAllSkillsInternal() throws IOException {
        Gson gson = new Gson();
        String json = readFromJsonFile();
        Type targetClassType = new TypeToken<ArrayList<Developer>>() {
        }.getType();
        List<Developer> developers = new Gson().fromJson(json, targetClassType);
        System.out.println(developers.size());
        System.out.println(developers);
        return developers;
    }

}
