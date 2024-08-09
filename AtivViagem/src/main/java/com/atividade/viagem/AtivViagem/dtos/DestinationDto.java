package com.atividade.viagem.AtivViagem.dtos;

import jakarta.validation.constraints.NotBlank;

public record DestinationDto(@NotBlank String name, @NotBlank String country) {
}
