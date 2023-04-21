package com.inventiveit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/*
  This class represents the data transfer object returned and shared by the application layers
*/

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class DreamCaseDTO{
    private BigDecimal caseId;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdateDate;
    private String title;
    private String description;

}
