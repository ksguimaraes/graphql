package com.example.graphql.domain.champions.dtos;

import java.util.Optional;

public record UpdateChampionDto(
    Optional<String> name,
    Optional<Integer> roleId,
    Optional<String> lore,
    Optional<String> imageUrl
) {
}
