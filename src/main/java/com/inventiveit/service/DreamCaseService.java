package com.inventiveit.service;

import com.inventiveit.dto.DreamCaseDTO;
import com.inventiveit.exception.DreamCaseNotFoundException;
import com.inventiveit.request.DreamCaseRequest;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

public interface DreamCaseService {

    ResponseEntity<DreamCaseDTO> getDreamCaseById(BigDecimal id) throws DreamCaseNotFoundException;

    ResponseEntity<DreamCaseDTO> updateDreamCase(BigDecimal id, DreamCaseRequest dreamCaseRequest) throws DreamCaseNotFoundException;

    ResponseEntity<DreamCaseDTO> createDreamCase(DreamCaseRequest dreamCaseRequest);

    ResponseEntity<DreamCaseDTO> deleteDreamCase(BigDecimal id) throws DreamCaseNotFoundException;
}
