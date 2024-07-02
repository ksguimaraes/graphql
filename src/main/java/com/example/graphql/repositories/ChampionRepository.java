package com.example.graphql.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.graphql.domain.champions.Champion;

@Repository
public interface ChampionRepository extends JpaRepository<Champion, Integer>{
    List<Champion> findByRole_Name(String roleName);
    List<Champion> findByName(String name);
    List<Champion> findByNameAndRole_Name(String name, String roleName);
}