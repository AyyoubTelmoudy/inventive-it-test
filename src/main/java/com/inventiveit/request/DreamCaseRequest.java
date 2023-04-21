package com.inventiveit.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*
This class containing fields that should be sent by client when creating or a updating a DreamCase record
*/

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class DreamCaseRequest {
    @NotNull
    @NotBlank
    @Size(min = 3,max = 50)
    private String title;
    @NotNull
    @NotBlank
    @Size(min = 3,max = 200)
    private String description;
}