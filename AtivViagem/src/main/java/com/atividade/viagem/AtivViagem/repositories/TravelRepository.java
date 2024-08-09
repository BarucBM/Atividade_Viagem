package com.atividade.viagem.AtivViagem.repositories;

import com.atividade.viagem.AtivViagem.model.TravelModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TravelRepository extends JpaRepository<TravelModel, Long> {

    @Query(value = "SELECT * FROM travel e WHERE EXTRACT(YEAR FROM e.startdate) = :year", nativeQuery = true)
    List<TravelModel> findAllByAno(@Param("year") int year);
}
