package com.maximatech.app.controller;

import com.maximatech.app.entity.Department;
import com.maximatech.app.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = DepartmentController.PATH)
public class DepartmentController {

    static final String PATH = "department";

    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("find-all")
    List<Department> findAll() {
        return this.departmentService.findAll();
    }

}
