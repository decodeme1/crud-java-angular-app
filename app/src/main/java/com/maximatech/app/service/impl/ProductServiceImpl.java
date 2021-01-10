package com.maximatech.app.service.impl;

import com.maximatech.app.entity.Product;
import com.maximatech.app.entity.dto.ProductFilterDTO;
import com.maximatech.app.repository.ProductRepository;
import com.maximatech.app.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAllEnabled();
    }

    @Override
    public Product getOne(Long productId) {
        return this.productRepository.getOne(productId);
    }

    @Override
    public List<Product> findByFilter(ProductFilterDTO productFilterDTO) {
        return this.productRepository.findByFilter(
                productFilterDTO.getCode(), productFilterDTO.getDescription(),
                productFilterDTO.getDepartmentId(), productFilterDTO.isEnabled()
        );
    }

    @Override
    public Product save(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public void delete(Long productId) {
        this.productRepository.deleteById(productId);
    }

}
