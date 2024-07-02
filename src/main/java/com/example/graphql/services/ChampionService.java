package com.example.graphql.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.graphql.domain.champions.Champion;
import com.example.graphql.domain.champions.dtos.UpdateChampionDto;
import com.example.graphql.domain.roles.Role;
import com.example.graphql.repositories.ChampionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChampionService {
    private final ChampionRepository championRepository;
    private final RoleService roleService;

    public List<Champion> getChampions(String name, String role) {
        if (name != null && role != null) {
            return championRepository.findByNameAndRole_Name(name, role);
        } else if (name != null) {
            return championRepository.findByName(name);
        } else if (role != null) {
            return championRepository.findByRole_Name(role);
        } else {
            return championRepository.findAll();
        }
    }

    public Champion getChampionById(int id) {
        return championRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Champion not found"));
    }

    public Champion createChampion(String name, int roleId, String lore, String imageUrl) {
        Role role = roleService.getRoleById(roleId);
        Champion champion = new Champion();
        champion.setName(name);
        champion.setRole(role);
        champion.setLore(lore);
        champion.setImageUrl(imageUrl);
        return championRepository.save(champion);
    }

    public Champion updateChampion(int id, UpdateChampionDto data) {;     
        Champion champion = championRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Champion not found"));
        data.name().ifPresent(champion::setName);
        data.roleId().ifPresent(roleId -> champion.setRole(roleService.getRoleById(roleId)));
        data.lore().ifPresent(champion::setLore);
        data.imageUrl().ifPresent(champion::setImageUrl);
        return championRepository.save(champion);
    }

    public boolean deleteChampion(int id) {
        if (championRepository.existsById(id)) {
            championRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
