package com.example.Product.Service;

import com.example.Product.Entity.Product;
import com.example.Product.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository repository;

    @Override
    public Product getProduct(String productId){
        Product product = repository.findOne(productId);
        System.out.println(product);
        return product;

    }

}
