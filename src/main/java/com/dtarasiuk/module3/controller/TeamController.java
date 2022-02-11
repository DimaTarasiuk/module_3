package com.dtarasiuk.module3.controller;

import com.dtarasiuk.module3.TeamStatus;
import com.dtarasiuk.module3.model.Developer;
import com.dtarasiuk.module3.model.Team;
import com.dtarasiuk.module3.repository.ITeamRepository;
import com.dtarasiuk.module3.repository.gson.GsonTeamRepositoryImpl;
import com.dtarasiuk.module3.repository.tmpRepo.TeamRepository;

import java.util.List;
import java.util.Scanner;

public class TeamController {
    private final ITeamRepository teamRepository = new GsonTeamRepositoryImpl();

    public Team createTeam(String name, TeamStatus status, List<Developer> developers){
        Team team = new Team();
        team.setName(name);
        team.setStatus(status);
        team.setDevelopers(developers);
        return teamRepository.save(team);
    }

    public Team updateTeam(Long id, String name, List<Developer> developers, TeamStatus status){
        Team team = new Team();
        team.setId(id);
        team.setName(name);
        team.setDevelopers(developers);
        team.setStatus(status);
        return teamRepository.update(team);
    }

    public void deleteTeam (Long id){
        teamRepository.deleteById(id);
    }

}
