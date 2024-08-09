package com.atividade.viagem.AtivViagem.repositories;

import com.atividade.viagem.AtivViagem.model.DestinationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DestinationRepository extends JpaRepository<DestinationModel, Long> {

    List<DestinationModel> findByCountry(String nameDestination);
}
