package com.inventiveit.mapper;

import com.inventiveit.dto.DreamCaseDTO;
import com.inventiveit.entity.DreamCase;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
/*
     This class contains the methods that can be used to transform DreamCase object to a DreamCaseDTO or the opposite
 */

@Component
public class DreamCaseMapper {
    /*
     This method is used to transform a DreamCaseObject to a DreamCaseDTO object
    */

    public DreamCaseDTO fromDreamCaseToDreamCaseDTO(DreamCase dreamCase)
    {
        DreamCaseDTO dreamCaseDTO=new DreamCaseDTO();
        BeanUtils.copyProperties(dreamCase,dreamCaseDTO);
        return dreamCaseDTO;
    }
}
