package com.example.Sample.service;

import com.example.Sample.model.Product;
import com.example.Sample.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public Product addProduct(Product product){
        return repo.save(product);
    }

    public List<Product> getAllProducts(){
        return repo.findAll();
    }

    public Product getProductById(Integer id){
        return repo.findById(id).orElse(null);
    }

    public Product updateProduct(Integer id,Product product){
        Product p = repo.findById(id).orElse(null);
        if (p != null) {
            p.setName(product.getName());
            p.setPrice(product.getPrice());
            return repo.save(p);
        }
        return null;
    }

    public Product patchProductPrice(Integer id ,double price){
        Product p = repo.findById(id).orElse(null);
        if (p != null){
            p.setPrice(price);
            return repo.save(p);
        }
        return null;
    }

    public String deleteProduct(Integer id){
        repo.deleteById(id);
        return "Product Deleted";
    }
}
