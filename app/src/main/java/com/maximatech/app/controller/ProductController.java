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

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("find-all")
    List<Product> findAll() {
        return this.productService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("find-by-filter")
    List<Product> findByFilter(@RequestBody ProductFilterDTO productFilterDTO) {
        return this.productService.findByFilter(productFilterDTO);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("get-one/{id}")
    Product getOne(@PathVariable Long id) {
        return this.productService.getOne(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("save")
    Product save(@RequestBody Product product) {
        return this.productService.save(product);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("product/{id}")
    void delete(@PathVariable Long productId) {
        this.productService.delete(productId);
    }

}
