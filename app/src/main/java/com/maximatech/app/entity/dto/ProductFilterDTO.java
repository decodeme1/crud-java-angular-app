package com.maximatech.app.entity.dto;

import lombok.Data;

@Data
public class ProductFilterDTO {

    private String code;

    private String description;

    private boolean enabled = true;

    private Long departmentId;

}
