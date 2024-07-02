package com.example.graphql.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.graphql.domain.champions.Champion;
import com.example.graphql.domain.champions.dtos.UpdateChampionDto;
import com.example.graphql.services.ChampionService;

@Controller
public class ChampionController {
    @Autowired
    private ChampionService championService;

    @QueryMapping
    public List<Champion> getChampions(@Argument String name, @Argument String role) {
        return championService.getChampions(name, role);
    }

    @QueryMapping
    public Champion getChampionById(@Argument int id) {
        return championService.getChampionById(id);
    }

    @MutationMapping
    public Champion createChampion(@Argument String name, @Argument int roleId, @Argument String lore, @Argument String imageUrl) {
        return championService.createChampion(name, roleId, lore, imageUrl);
    }

    @MutationMapping
    public Champion updateChampion(@Argument int id, @Argument UpdateChampionDto data) {
        return championService.updateChampion(id, data);
    }

    @MutationMapping
    public boolean deleteChampion(@Argument int id) {
        return championService.deleteChampion(id);
    }
}
