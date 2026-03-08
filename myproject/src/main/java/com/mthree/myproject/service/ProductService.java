package com.mthree.myproject.service;

import com.mthree.myproject.entity.Product;
import com.mthree.myproject.repository.ProductRepository;
import  org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(Long id){
        return productRepository.findById(id).orElse(null);
    }

    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    public Product updateProduct(Long id, Product product){
        Product prod = productRepository.findById(id).orElse(null);
        if (prod!= null){
            prod.setName(product.getName());
            prod.setPrice(product.getPrice());
            productRepository.save(prod);
            return  prod;
        }
        return  null;

    }
}
