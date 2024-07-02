package com.example.graphql.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.graphql.domain.roles.Role;
import com.example.graphql.repositories.RoleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public List<Role> getRoles(String name) {
        if(name != null) {
            return roleRepository.findByName(name);
        }else {
            return roleRepository.findAll();
        }
    }

    public Role getRoleById(int id) {
        return roleRepository.findById(id).orElse(null);
    }
}
