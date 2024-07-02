package com.example.graphql.domain.champions;

import com.example.graphql.domain.roles.Role;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "champions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Champion {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(columnDefinition = "TEXT")
    private String lore;

    @Column(name = "image_url")
    private String imageUrl;

    public Champion(String name, Role role, String lore, String imageUrl) {
        this.name = name;
        this.role = role;
        this.lore = lore;
        this.imageUrl = imageUrl;
    }
}
