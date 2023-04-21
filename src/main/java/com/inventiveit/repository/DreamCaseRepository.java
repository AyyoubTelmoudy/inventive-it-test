package com.inventiveit.repository;

import com.inventiveit.entity.DreamCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
/*
 This interface is the JPA interface tha interacts with the database and manipulating DreamCase records
*/

@Repository
public interface DreamCaseRepository extends JpaRepository<DreamCase,BigDecimal> {
    /*
    This method retrieves a DreamCase record by its id
     */
    DreamCase findByCaseId(BigDecimal caseId);

    /*
     This method deletes a DreamCase record by its id
    */
    void deleteByCaseId(BigDecimal caseId);
}
