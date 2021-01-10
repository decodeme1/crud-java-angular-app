package com.maximatech.app.repository;

import com.maximatech.app.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT p FROM PRODUCT p Where (p.code is null or p.code = 1) and (p.description is null or p.description = 2) and (p.department_id is null or p.department_id = 3) and (p.enabled = 4)", nativeQuery = true)
    List<Product> findByFilter(@Param("name") String code, @Param("description")String description, @Param("departmentId")Long departmentId, boolean enabled);

    @Query(value = "SELECT * FROM PRODUCT WHERE ENABLED = TRUE", nativeQuery = true)
    List<Product> findAllEnabled();

}
