package com.example.graphql.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.graphql.domain.roles.Role;
import com.example.graphql.services.RoleService;


@Controller
public class RoleController {
    @Autowired
    private RoleService roleService;

    @QueryMapping
    public List<Role> getRoles(@Argument String name) {
        return roleService.getRoles(name);
    }
}
