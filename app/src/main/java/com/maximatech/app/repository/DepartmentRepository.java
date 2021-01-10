package com.maximatech.app.repository;

import com.maximatech.app.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query(value = "SELECT * FROM DEPARTMENT WHERE UUID = ?1 AND CODE = ?2", nativeQuery = true)
    List<Department> existByIdUUIDAndCode(String id, String code);

}
