package com.maximatech.app.controller;

import com.maximatech.app.entity.Product;
import com.maximatech.app.entity.dto.ProductFilterDTO;
import com.maximatech.app.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = ProductController.PATH)
public class ProductController {

    static final String PATH = "product";

    private ProductService productService;

    public ProductController(ProductService ProductService) {
        this.productService = ProductService;
    }

    @GetMapping("find-all")
    List<Product> findAll() {
        return this.productService.findAll();
    }

    @PostMapping("find-by-filter")
    List<Product> findByFilter(@RequestBody ProductFilterDTO productFilterDTO) {
        return this.productService.findByFilter(productFilterDTO);
    }

    @GetMapping("get-one{/productId}")
    Product getOne(@PathVariable Long productId) {
        return this.productService.getOne(productId);
    }

    @PostMapping("save")
    Product save(@RequestBody Product product) {
        return this.productService.save(product);
    }

    @DeleteMapping("product/{id}")
    void delete(@PathVariable Long productId) {
        this.productService.delete(productId);
    }

}
