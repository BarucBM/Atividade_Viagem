package com.atividade.viagem.AtivViagem.dtos;

import com.atividade.viagem.AtivViagem.model.TravelModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DestinationDto(@NotBlank String name, @NotBlank String country) {
}
