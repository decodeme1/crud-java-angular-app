package com.maximatech.app.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DepartmentDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("codigo")
    private String code;

    @JsonProperty("nome")
    private String name;


}
