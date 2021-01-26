package com.maximatech.app.repository;

import com.maximatech.app.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = " select p from Product p " +
            "where ( p.description is null or p.description like %:description% )" +
            " or ( p.code is null or p.code like %:code% ) " +
            " or ( p.department.id is null or p.department.id = :department_id) ")
    List<Product> findByFilter( @Param("code") String code, @Param("description") String description, @Param("department_id") Long department_id );

    @Query(value = "SELECT * FROM PRODUCT WHERE ENABLED = TRUE", nativeQuery = true)
    List<Product> findAllEnabled();

    @Override
    @Query(value = " select p from Product p where p.id = :id " )
    Product getOne(@Param("id") Long id);
}
