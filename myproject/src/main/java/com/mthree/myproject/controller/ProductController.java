package com.mthree.myproject.controller;

import com.mthree.myproject.entity.Product;
import com.mthree.myproject.service.ProductService;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController (ProductService productService){
        this.productService = productService;
    }

    @PostMapping
    public Product addNewProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return  productService.getAllProducts();
    }
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id){
        return  productService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product updateProduct){
        return  productService.updateProduct(id, updateProduct);
    }


}
