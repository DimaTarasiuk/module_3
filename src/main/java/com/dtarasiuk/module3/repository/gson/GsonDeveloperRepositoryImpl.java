package com.dtarasiuk.module3.repository.gson;
import com.dtarasiuk.module3.model.Developer;
import com.dtarasiuk.module3.repository.IDeveloperRepository;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GsonDeveloperRepositoryImpl implements IDeveloperRepository {
    final String pathToTheFle = "C:\\Users\\dtarasiuk\\IdeaProjects\\module_3\\src\\main\\resources\\developers.json";

    private String readFromJsonFile() {
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
    }private void writeDevelopersToFile(List<Developer> developers){
        String newJsonDevelopers = new Gson().toJson(developers);
        try {
            FileOutputStream fos = new FileOutputStream(pathToTheFle);
            fos.write(newJsonDevelopers.getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private List<Developer> getAllDevelopersInternal() {
        String json = readFromJsonFile();
        Type targetClassType = new TypeToken<ArrayList<Developer>>() {
        }.getType();
        List<Developer> developers = new Gson().fromJson(json, targetClassType);
        return new Gson().fromJson(json, targetClassType);
    }
    private Long generateId() {
        List<Developer> developers = getAllDevelopersInternal();
        Long id = developers.stream().mapToLong(Developer::getId).max().orElse(-1);
        return id+1;
    }
    @Override
    public void deleteById(Long id){
        List<Developer> developers = getAllDevelopersInternal();
        developers.removeIf(d->d.getId().equals(id));
        writeDevelopersToFile(developers);
    }
    @Override
    public Developer getByID(Long id){
        return getAllDevelopersInternal().stream().filter(s-> s.getId().equals(id)).findAny().orElse(null);
    }

    public Developer save(Developer developer) {
        developer.setId(generateId());
        List<Developer> developersList = getAllDevelopersInternal();
        developersList.add(developer);
        writeDevelopersToFile(developersList);
        return developer;
    }

    public List<Developer> getAll(){
        List<Developer> devList = getAllDevelopersInternal();
        for(Developer dList : devList){
            devList.add(dList);
        }
        return devList;
    }
    public Developer update(Developer developer){
        List<Developer> developerList = getAllDevelopersInternal();
        developerList.forEach(s -> {
            if(s.getId().equals(developer.getId())){
                s.setFirstName(developer.getFirstName());
                s.setLastName(developer.getLastName());
            }
        });
        writeDevelopersToFile(developerList);
        return developer;
    }
}
