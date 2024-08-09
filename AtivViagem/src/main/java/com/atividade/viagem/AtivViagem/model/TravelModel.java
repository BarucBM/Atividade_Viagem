package com.atividade.viagem.AtivViagem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "travel")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TravelModel implements Serializable {
    private static final long serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private Date startDate;

    private Date endDate;

    @ManyToOne
    private DestinationModel destination;

}

