package com.dtarasiuk.module3.repository;
import com.dtarasiuk.module3.model.Developer;
import com.dtarasiuk.module3.model.Skill;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DeveloperRepository {
    final String pathToTheFle = "C:\\Users\\dtarasiuk\\IdeaProjects\\module_3\\src\\main\\resources\\developers.json";

    public String readFromJsonFile() {
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

    private List<Developer> getAllDevelopersInternal() {
        Gson gson = new Gson();
        String json = readFromJsonFile();
        Type targetClassType = new TypeToken<ArrayList<Developer>>() {
        }.getType();
        List<Developer> developers = new Gson().fromJson(json, targetClassType);
        return new Gson().fromJson(json, targetClassType);
    }
    public Long generateId() {
        List<Developer> developers = getAllDevelopersInternal();
        Long id = developers.stream().mapToLong(Developer::getId).max().orElse(-1);
        return id+1;
    }
    public void deleteById(Long id){
        List<Developer> developers = getAllDevelopersInternal();
        developers.removeIf(d->d.getId().equals(id));
        writeDevelopersToFile(developers);
    }

    public Developer save(Developer developer) {
        developer.setId(generateId());
        List<Developer> developersList = getAllDevelopersInternal();
        developersList.add(developer);
        writeDevelopersToFile(developersList);
        return developer;
    }
    public void writeDevelopersToFile(List<Developer> developers){
        String newJsonDevelopers = new Gson().toJson(developers);
        try {
            FileOutputStream fos = new FileOutputStream(pathToTheFle);
            fos.write(newJsonDevelopers.getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
