package com.dtarasiuk.module3.repository;

import com.dtarasiuk.module3.model.Skill;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SkillRepository {

    public String readFromJsonFile() throws IOException {
        String filePath = "C:\\Users\\dtarasiuk\\Desktop\\skills.json";
        String staticJson = "[{\"id\": 1,\"name\": \"KOTLIN\"},{\"id\":2,\"name\":\"SQL\"},{\"id\":3,\"name\":\"JAVA\"}";

        String jsonData = null;
        FileInputStream fileInputStream = new FileInputStream(filePath);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);

        try (BufferedReader bf = new BufferedReader(inputStreamReader)) {
            String line;
            while ((line = bf.readLine()) != null) {
                System.out.println(jsonData);
                jsonData = line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonData;
    }


    public Skill getByID(Long id) throws IOException {
        return getAllSkillsInternal().stream().filter(s -> s.getId().equals(id)).findAny().orElse(null);
    }

    public List<Skill> getAll() throws IOException {
        return getAllSkillsInternal();
    }

    public Skill save(Skill skill) throws IOException {
        skill.setId(generateId());
        List<Skill> skills = getAllSkillsInternal();
        skills.add(skill);
        //return writeSkillsToFile(skills);
        return null;
    }

//   public Skill update(Skill skill){
//      List<Skill> skills = getAllSkillsInternal();
//      skills.stream.peek(s -> {if(s.getId().equals(skill.getId())){skill.setName(skill.getName())}});
//      writeSkillsToFile(skills);
//   }

    private long generateId() {
        return 12L;
    }

    public List<Skill> getAllSkillsInternal() throws IOException {
        Gson gson = new Gson();
        String json = readFromJsonFile();
        Type targetClassType = new TypeToken<ArrayList<Skill>>() {
        }.getType();
        List<Skill> skills = new Gson().fromJson(json, targetClassType);
        System.out.println("Size of collection" + skills.size());
        return null;
    }

    private void writeSkillsToFile(List<Skill> skills) {

    }


}


