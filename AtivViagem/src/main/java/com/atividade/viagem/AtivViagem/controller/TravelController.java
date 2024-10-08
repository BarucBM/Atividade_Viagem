package com.atividade.viagem.AtivViagem.controller;


import com.atividade.viagem.AtivViagem.dtos.DestinationDto;
import com.atividade.viagem.AtivViagem.dtos.TravelDto;
import com.atividade.viagem.AtivViagem.model.DestinationModel;
import com.atividade.viagem.AtivViagem.model.TravelModel;
import com.atividade.viagem.AtivViagem.repositories.DestinationRepository;
import com.atividade.viagem.AtivViagem.repositories.TravelRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/travel")
public class TravelController {

    @Autowired
    TravelRepository travelRepository;

    @Autowired
    DestinationRepository destinationRepository;

    @GetMapping
    public ResponseEntity<List<TravelModel>> getAllTravels(){
        return ResponseEntity.status(HttpStatus.OK).body(travelRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getTravelById(@PathVariable(value = "id") Long id){
        TravelModel travel = travelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Travel not found!"));

        return ResponseEntity.status(HttpStatus.OK).body(travel);
    }

    @PostMapping
    public ResponseEntity<Object> addTravel (@RequestBody @Valid TravelDto travelDto){
        TravelModel travel =new TravelModel();
        DestinationModel destination = destinationRepository.findById(travelDto.destinationId())
                        .orElseThrow(() -> new RuntimeException("Destination not found!"));

        BeanUtils.copyProperties(travelDto, travel);
        travel.setDestination(destination);
        return ResponseEntity.status(HttpStatus.CREATED).body(travelRepository.save(travel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTravel (@PathVariable(value = "id") Long id, @RequestBody @Valid TravelDto travelDto){
        TravelModel travel = travelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Travel not found!"));

        BeanUtils.copyProperties(travelDto, travel);
        return ResponseEntity.status(HttpStatus.OK).body(travelRepository.save(travel));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<String> deleteTravel(@PathVariable(value="id") Long id){
        TravelModel travel= travelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Travel not found!"));

        travelRepository.deleteById(travel.getId());
        return ResponseEntity.status(HttpStatus.OK).body("Travel deleted!");
    }

    @GetMapping("/destination/{id}/travels")
    public ResponseEntity<List<TravelModel>> getTravelByDestination (@PathVariable(value = "id") Long id){
        DestinationModel destination = destinationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Destination not found!"));

        return ResponseEntity.status(HttpStatus.OK).body(destination.getTravels());
    }

    // Get que retorna as viagens que começaram no ano indicado
    @GetMapping("/year/{year}")
    public ResponseEntity<List<TravelModel>> getTravelByStartYear(@PathVariable(value = "year")int year){
        List<TravelModel> travel = travelRepository.findAllByAno(year);

        return ResponseEntity.status(HttpStatus.OK).body(travel);
    }
}