package com.inventiveit.controller;

import com.inventiveit.dto.DreamCaseDTO;
import com.inventiveit.exception.DreamCaseNotFoundException;
import com.inventiveit.request.DreamCaseRequest;
import com.inventiveit.service.DreamCaseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

/*
This class represents the controller that exposes the endpoints of handling DreamCase records
*/
@RestController
@RequestMapping("/cases")
@AllArgsConstructor
public class DreamCaseController {

    private final DreamCaseService dreamCaseService;
    /*
    This API returns a DreamCase record by its id (caseId) passed in argument
     */
    @GetMapping("/{id}")
    public ResponseEntity<DreamCaseDTO> getDreamCaseById(@PathVariable BigDecimal id) throws DreamCaseNotFoundException {
       return dreamCaseService.getDreamCaseById(id);
    }

    /*
    This API returns all dreamCases
    */
    @GetMapping
    public ResponseEntity<List<DreamCaseDTO>> getAllDreamCases(){
        return dreamCaseService.getAllDreamCases();
    }

    /*
      This API updates a DreamCase record
    */
    @PutMapping("/{id}")
    public ResponseEntity<DreamCaseDTO> updateDreamCase(@PathVariable BigDecimal id, @RequestBody @Valid DreamCaseRequest dreamCaseRequest) throws DreamCaseNotFoundException {
        return dreamCaseService.updateDreamCase(id,dreamCaseRequest);
    }

    /*
      This API create a save a DreamCase record containing the values of the DreamCaseRequest object argument
    */
    @PostMapping
    public ResponseEntity<DreamCaseDTO> createDreamCase(@RequestBody @Valid DreamCaseRequest dreamCaseRequest)
    {
        return dreamCaseService.createDreamCase(dreamCaseRequest);
    }

    /*
      This API delete a DreamCase record by its id (caseId)
    */
    @DeleteMapping("/{id}")
    public ResponseEntity<DreamCaseDTO> deleteDreamCaseById(@PathVariable BigDecimal id) throws DreamCaseNotFoundException {
        return dreamCaseService.deleteDreamCase(id);
    }

}
