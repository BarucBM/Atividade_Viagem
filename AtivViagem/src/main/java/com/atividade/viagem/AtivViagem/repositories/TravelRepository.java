package com.atividade.viagem.AtivViagem.repositories;

import com.atividade.viagem.AtivViagem.model.TravelModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelRepository extends JpaRepository<TravelModel, Long> {
}
