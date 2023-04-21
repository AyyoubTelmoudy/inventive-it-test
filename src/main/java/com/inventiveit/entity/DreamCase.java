package com.inventiveit.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/*
  This class is the persisting entity that would get transformed in a table in the database
*/
@Entity
@Table(name = "dream_cases")
@NoArgsConstructor @AllArgsConstructor @Data @ToString
public class DreamCase {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private BigDecimal caseId;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdateDate;
    private String title;
    private String description;

}
