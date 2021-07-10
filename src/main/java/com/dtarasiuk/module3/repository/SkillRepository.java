package com.dtarasiuk.module3.repository;

import com.dtarasiuk.module3.model.Skill;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

//method scrapps json data from the file and convert it to String
public class SkillRepository {

    public String readFromJsonFile(){
        String pathToTheFle = "C:\\Users\\dtarasiuk\\IdeaProjects\\module_3\\src\\main\\resources\\skills.json" ;
        List<Skill> skills = new ArrayList<>();
        try {
            File input = new File(pathToTheFle);
            JsonElement skillsElements = JsonParser.parseReader(new FileReader(input));
            JsonObject fileObject = skillsElements.getAsJsonObject();
            JsonArray skillsArray = fileObject.getAsJsonArray();

            for(JsonElement element : skillsArray ){
                //getting json obj
                JsonObject skillJsonObject = element.getAsJsonObject();

                //extract data
                Long id = skillJsonObject.get("id").getAsLong();
                String name =  skillJsonObject.get("name").getAsString();

                Skill skill = new Skill(id, name);
                skills.add(skill);
            }

            System.out.println(skills);


        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return null;
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



    private void writeSkillsToFile(List<Skill> skills) {

    }


}


