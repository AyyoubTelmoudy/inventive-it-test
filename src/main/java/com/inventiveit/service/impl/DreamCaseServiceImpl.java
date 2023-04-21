package com.inventiveit.service.impl;

import com.inventiveit.constant.ErrorMessage;
import com.inventiveit.dto.DreamCaseDTO;
import com.inventiveit.entity.DreamCase;
import com.inventiveit.exception.DreamCaseNotFoundException;
import com.inventiveit.mapper.DreamCaseMapper;
import com.inventiveit.repository.DreamCaseRepository;
import com.inventiveit.request.DreamCaseRequest;
import com.inventiveit.service.DreamCaseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/*
This is the service layer that containing all methods used by the controller layer and responsible for the business taken over records
 */
@Service
@AllArgsConstructor
@Transactional
public class DreamCaseServiceImpl implements DreamCaseService {
    private final DreamCaseMapper dreamCaseMapper;

    private final DreamCaseRepository dreamCaseRepository;
    /*
    This method returns a DreamCase record by its id (caseId) passed in argument
     */
    @Override
    public ResponseEntity<DreamCaseDTO> getDreamCaseById(BigDecimal id) throws DreamCaseNotFoundException {
        DreamCase dreamCase=dreamCaseRepository.findByCaseId(id);
        if(dreamCase!=null)
        {
            DreamCaseDTO dreamCaseDTO=dreamCaseMapper.fromDreamCaseToDreamCaseDTO(dreamCase);
            return new ResponseEntity<>(dreamCaseDTO,new HttpHeaders(), HttpStatus.ACCEPTED);
        }
        else
        {
            throw new DreamCaseNotFoundException(ErrorMessage.DREAM_CASE_NOT_FOUND);
        }
    }
    /*
      This method updates a DreamCase record
    */
    @Override
    public ResponseEntity<DreamCaseDTO> updateDreamCase(BigDecimal id, DreamCaseRequest dreamCaseRequest) throws DreamCaseNotFoundException {
       DreamCase dreamCase=dreamCaseRepository.findByCaseId(id);
        if(dreamCase!=null)
        {
            dreamCase.setDescription(dreamCaseRequest.getDescription());
            dreamCase.setTitle(dreamCaseRequest.getTitle());
            dreamCase.setLastUpdateDate(LocalDateTime.now());
            dreamCase=dreamCaseRepository.save(dreamCase);

            DreamCaseDTO dreamCaseDTO=dreamCaseMapper.fromDreamCaseToDreamCaseDTO(dreamCase);
            return new ResponseEntity<>(dreamCaseDTO,new HttpHeaders(), HttpStatus.ACCEPTED);
        }
        else
        {
            throw new DreamCaseNotFoundException(ErrorMessage.DREAM_CASE_NOT_FOUND);
        }
    }
    /*
      This method create a save a DreamCase record containing the values of the DreamCaseRequest object argument
    */
    @Override
    public ResponseEntity<DreamCaseDTO> createDreamCase(DreamCaseRequest dreamCaseRequest) {
        DreamCase dreamCase=new DreamCase(null, LocalDateTime.now(),LocalDateTime.now(),dreamCaseRequest.getTitle(),dreamCaseRequest.getDescription());
        dreamCase=dreamCaseRepository.save(dreamCase);

        DreamCaseDTO dreamCaseDTO=dreamCaseMapper.fromDreamCaseToDreamCaseDTO(dreamCase);
        return new ResponseEntity<>(dreamCaseDTO,new HttpHeaders(), HttpStatus.ACCEPTED);
    }

    /*
     This method delete a DreamCase record by its id (caseId)
    */
    @Override
    public ResponseEntity<DreamCaseDTO> deleteDreamCase(BigDecimal id) throws DreamCaseNotFoundException {
        DreamCase dreamCase=dreamCaseRepository.findByCaseId(id);
        if(dreamCase!=null)
        {
            dreamCaseRepository.deleteByCaseId(id);
            return new ResponseEntity<>(new HttpHeaders(), HttpStatus.ACCEPTED);
        }
        else
        {
            throw new DreamCaseNotFoundException(ErrorMessage.DREAM_CASE_NOT_FOUND);
        }
    }
}
