package com.example.SpringSecurity.service.impl;

import com.example.SpringSecurity.model.Product;
import com.example.SpringSecurity.repository.ProductRepo;
import com.example.SpringSecurity.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<Product> findAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Optional<Product> findProductByName(String name) {
        return productRepo.findProductByName(name);
    }

    @Override
    public String saveProduct(Product product) {
        Product savePoduct = productRepo.save(product);
        if (savePoduct != null && savePoduct.getName() != "") {
            return "PRODUCT WAS SUCCESSFULLY SAVED";
        }
        return "PLEASE TRY AGAIN< PRODUCT NOT SAVED";
    }
}
