package com.atividade.viagem.AtivViagem.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record TravelDto(@NotBlank String title, @NotNull Date startDate, @NotNull Date endDate) {
}
