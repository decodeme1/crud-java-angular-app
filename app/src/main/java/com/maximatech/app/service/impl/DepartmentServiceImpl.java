package com.maximatech.app.service.impl;

import com.maximatech.app.entity.Department;
import com.maximatech.app.entity.dto.DepartmentDTO;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.maximatech.app.repository.DepartmentRepository;
import com.maximatech.app.service.DepartmentService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @EventListener(ContextRefreshedEvent.class)
    @Scheduled(cron = "0 * * * * *")
    public void synchronizeDepartments() {
        RestTemplate restTemplate = new RestTemplate();
        DepartmentDTO[] tempDepartments = restTemplate.getForObject("https://private-anon-3d4eeadca5-maximatech.apiary-mock.com/fullstack/departamento", DepartmentDTO[].class);
        List<DepartmentDTO> departmentDTOList = Arrays.asList(tempDepartments);
        List<Department> departmentList = new ArrayList<>();
        departmentDTOList.forEach(departmentDTO -> {
            if (this.departmentRepository.existByIdUUIDAndCode(departmentDTO.getId(), departmentDTO.getCode()).isEmpty()) {
                departmentList.add(new Department(departmentDTO.getId(), departmentDTO.getCode(), departmentDTO.getName()));
            }
        });
        this.departmentRepository.saveAll(departmentList);
    }

    @Override
    public List<Department> findAll() {
        return this.departmentRepository.findAll();
    }

}
