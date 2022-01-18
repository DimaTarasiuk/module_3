package com.dtarasiuk.module3.repository.gson;

import com.dtarasiuk.module3.model.Team;
import com.dtarasiuk.module3.repository.ITeamRepository;
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

public class GsonTeamRepositoryImpl implements ITeamRepository {
    final String pathToTheFle = "C:\\Users\\dtarasiuk\\IdeaProjects\\module_3\\src\\main\\resources\\teams.json";

    private String readFromJsonFile(){
        String teamsAsString = null;
        List<Team> teams = new ArrayList<>();
        Gson gson = new Gson();

        try {
            File input = new File(pathToTheFle);
            JsonElement teamsElements = JsonParser.parseReader(new FileReader(input));
            JsonArray fileObject = teamsElements.getAsJsonArray();
            teamsAsString = fileObject.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return teamsAsString;
    }

    private List<Team> getAllTeamsInternal(){
        String json = readFromJsonFile();
        Type targetClassType = new TypeToken<ArrayList<Team>>(){}.getType();//???
        List<Team> teams = new Gson().fromJson(json,targetClassType);
        System.out.println("teams size" + teams.size());
        return teams;
    }

    private Long generateId(){
        List<Team> teams = getAllTeamsInternal();
        Long id = teams.stream().mapToLong(Team::getId).max().orElse(-1);
        return id+1;
    }

    public Team getByID(Long id){
        return getAllTeamsInternal().stream().filter(s -> s.getId().equals(id)).findAny().orElse(null);
    }

    public void deleteById(Long id){
        List<Team> teamList = getAllTeamsInternal();
        teamList.removeIf(t -> t.getId().equals(id));
        writeTeamsToFile(teamList);
    }

    public List<Team> getAll(){
        List<Team> teamList = getAllTeamsInternal();
        for(Team tList : teamList){
            teamList.add(tList);
        }
        return teamList;
    }

    public Team update(Team team){
        List<Team> teamsList = getAllTeamsInternal();
        teamsList.forEach(s -> {
            if (s.getId().equals(team.getId())){
                s.setName(team.getName());
            }
        });
        writeTeamsToFile(teamsList);
        return team;
    }

    public Team save(Team team){
        team.setId(generateId());
        List<Team> teams = getAllTeamsInternal();
        teams.add(team);
        writeTeamsToFile(teams);
        return team;
    }

    private void writeTeamsToFile(List<Team> teams){
        String newJsonTeams = new Gson().toJson(teams);
        try {
            FileOutputStream fos = new FileOutputStream(pathToTheFle);
            fos.write(newJsonTeams.getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
