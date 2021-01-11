package com.maximatech.app.service;

import com.maximatech.app.entity.Product;
import com.maximatech.app.entity.dto.ProductFilterDTO;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product getOne(Long id);

    List<Product> findByFilter(ProductFilterDTO productFilterDTO);

    Product save(Product product);

    void delete(Long productId);
}
