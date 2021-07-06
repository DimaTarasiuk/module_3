package com.dtarasiuk.module3.repository;

import com.dtarasiuk.module3.model.Skill;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

//method scrapps json data from the file and convert it to String
public class SkillRepository {

    public String readFromJsonFile() throws IOException {
        String filePath = "C:\\Users\\dtarasiuk\\Desktop\\skills.json";
        String jsonData = null;
        FileInputStream fileInputStream = new FileInputStream(filePath);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);

        try (BufferedReader bf = new BufferedReader(inputStreamReader)) {
            String line;
            while ((line = bf.readLine()) != null) {
                jsonData += line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (jsonData != null)
            jsonData.toString();
        return jsonData;
    }


    //method returns skill by specific id
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
        //String staticJson = "[{\"id\": 1,\"name\": \"KOTLIN\"},{\"id\":2,\"name\":\"SQL\"},{\"id\":3,\"name\":\"JAVA\"}]";
        String json = readFromJsonFile();
        Type targetClassType = new TypeToken<ArrayList<Skill>>() {
        }.getType();
        List<Skill> skills = new Gson().fromJson(json, targetClassType);
        System.out.println(skills.size());
        return skills;
    }

    private void writeSkillsToFile(List<Skill> skills) {

    }


}


