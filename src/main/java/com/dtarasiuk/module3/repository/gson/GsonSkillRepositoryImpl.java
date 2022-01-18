package com.dtarasiuk.module3.repository.gson;

import com.dtarasiuk.module3.model.Skill;
import com.dtarasiuk.module3.repository.ISkillRepository;
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

public class GsonSkillRepositoryImpl implements ISkillRepository {
    final String pathToTheFle = "C:\\Users\\dtarasiuk\\IdeaProjects\\module_3\\src\\main\\resources\\skills.json";

    public Skill getById(Long id) {
        return getAllSkillsInternal().stream().filter(s -> s.getId().equals(id)).findAny().orElse(null);
    }

    public void deleteById(Long id) {
        List<Skill> skillList = new ArrayList<>();
        skillList = getAllSkillsInternal();
        skillList.removeIf(s -> s.getId().equals(id));
        writeSkillsToFile(skillList);
    }

    public List<Skill> getAll() {
        return getAllSkillsInternal();
    }

    public Skill getByID(Long id){
        return getAllSkillsInternal().stream().filter(s -> s.getId().equals(id)).findAny().orElse(null);
    }

    public Skill save(Skill skill) {
        skill.setId(generateId());
        List<Skill> skills = getAllSkillsInternal();
        skills.add(skill);
        writeSkillsToFile(skills);
        return skill;
    }

    public Skill update(Skill skill) {
        List<Skill> skills = getAllSkillsInternal();
        skills.forEach(s -> {
            if (s.getId().equals(skill.getId())) {
                s.setName(skill.getName());
            }
        });
        writeSkillsToFile(skills);
        return skill;
    }

    private Long generateId() {
        List<Skill> skills = getAllSkillsInternal();
        Long id = skills.stream().mapToLong(Skill::getId).max().orElse(-1);
        return id + 1;
    }

    public String readFromJsonFile() {
        String skillsAsString = null;
        List<Skill> skills = new ArrayList<>();
        Gson gson = new Gson();

        try {
            File input = new File(pathToTheFle);
            JsonElement skillsElements = JsonParser.parseReader(new FileReader(input));
            JsonArray fileObject = skillsElements.getAsJsonArray();
            skillsAsString = fileObject.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return skillsAsString;
    }

    private void writeSkillsToFile(List<Skill> skills) {

        String newSkills = new Gson().toJson(skills);
        try (FileOutputStream oos = new FileOutputStream(pathToTheFle)) {
            oos.write(newSkills.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<Skill> getAllSkillsInternal() {
        String json = readFromJsonFile();
        Type targetClassType = new TypeToken<ArrayList<Skill>>() {
        }.getType();
        return new Gson().fromJson(json, targetClassType);
    }
}
