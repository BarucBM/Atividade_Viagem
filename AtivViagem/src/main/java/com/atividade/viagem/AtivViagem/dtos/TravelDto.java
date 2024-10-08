package com.atividade.viagem.AtivViagem.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;


public record TravelDto(@NotBlank String title, @NotNull LocalDate startDate, @NotNull LocalDate endDate, @NotNull Long destinationId) {
}
