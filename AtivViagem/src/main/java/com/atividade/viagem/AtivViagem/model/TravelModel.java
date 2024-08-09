package com.atividade.viagem.AtivViagem.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "travel")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TravelModel implements Serializable {
    private static final long serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "startdate")
    private LocalDate startDate;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "enddate")
    private LocalDate endDate;

    @JsonIgnore
    @ManyToOne
    private DestinationModel destination;

}

