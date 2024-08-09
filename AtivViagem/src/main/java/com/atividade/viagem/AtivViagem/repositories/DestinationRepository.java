package com.atividade.viagem.AtivViagem.repositories;

import com.atividade.viagem.AtivViagem.model.DestinationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinationRepository extends JpaRepository<DestinationModel, Long> {

}
