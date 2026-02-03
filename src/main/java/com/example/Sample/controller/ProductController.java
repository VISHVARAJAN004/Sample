package com.example.Sample.controller;

import com.example.Sample.model.Product;
import com.example.Sample.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;
import com.example.Sample.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping("/product")
    public Product create(@RequestBody Product product){
        return productRepository.save(product);
    }

    @GetMapping
    public List<Product> getAll(){
        return productRepository.findAll();
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Integer id ,@RequestBody Product product){
        return productRepository.findById(id).orElse(null);
    }

    @PatchMapping("/{id}/price")
    public Product patchPrice(@PathVariable Integer id ,@RequestBody Product product){
        Product existing = productRepository.findById(id).orElse(null);
        if(existing !=null){
            existing.setPrice(product.getPrice());
            return productRepository.save(existing);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        if(productRepository.existsById(id)){
            productRepository.deleteById(id);
            return "Product Deleted Successfully";
        }
        return "Product not Found";
    }


}
