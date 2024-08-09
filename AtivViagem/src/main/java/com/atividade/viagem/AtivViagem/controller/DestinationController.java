package com.atividade.viagem.AtivViagem.controller;


import com.atividade.viagem.AtivViagem.dtos.DestinationDto;
import com.atividade.viagem.AtivViagem.dtos.TravelDto;
import com.atividade.viagem.AtivViagem.model.DestinationModel;
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
@RequestMapping("/destination")
public class DestinationController {

    @Autowired
    DestinationRepository destinationRepository;

    @Autowired
    TravelRepository travelRepository;

    @GetMapping
    public ResponseEntity<List<DestinationModel>> getAllDestinations(){
        return ResponseEntity.status(HttpStatus.OK).body(destinationRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getDestinationById(@PathVariable(value = "id") Long id){
        DestinationModel destination = destinationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Destination not found!"));

        return ResponseEntity.status(HttpStatus.OK).body(destination);
    }

    @PostMapping
    public ResponseEntity<Object> addDestination (@RequestBody @Valid DestinationDto destinationDto){
        DestinationModel destination =new DestinationModel();
        BeanUtils.copyProperties(destinationDto, destination);
        return ResponseEntity.status(HttpStatus.CREATED).body(destinationRepository.save(destination));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateDestination (@PathVariable(value = "id") Long id, @RequestBody @Valid DestinationDto destinationDto){
        DestinationModel destination = destinationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Destination not found!"));
        BeanUtils.copyProperties(destinationDto, destination);
        return ResponseEntity.status(HttpStatus.OK).body(destinationRepository.save(destination));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<String> deleteDestination(@PathVariable(value="id") Long id){
        DestinationModel destination = destinationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Destination not found!"));
            destinationRepository.deleteById(destination.getId());
            return ResponseEntity.status(HttpStatus.OK).body("Destinations deleted!");
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<DestinationModel>> getDestinationByName (@PathVariable(value = "name") String name){
       List<DestinationModel> destination = destinationRepository.findByCountry(name);

           return ResponseEntity.status(HttpStatus.OK).body(destination);



    }

}
