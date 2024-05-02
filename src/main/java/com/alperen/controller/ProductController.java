package com.alperen.controller;

import com.alperen.entity.Product;
import com.alperen.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product") //localhost:8080/product
@RequiredArgsConstructor
//@CrossOrigin("*")
public class ProductController {

    private final ProductService productService;

    /*
    http://localhost:8080/product/save?
    productName=SampleProduct&
    productCategory=SampleCategory&
    productPrice=19.99&
    productUnitInStock=100&
    productDescription=SampleDescription
     */
    @PostMapping("/save")
        public Product save(@RequestBody Product product){
            return productService.save(product);
    }

    @GetMapping("/find-all") //http://localhost:8080/product/find-all
    public List<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping("/find-by-id") //http://localhost:8080/product/find-by-id?id=1
    public Optional<Product> findById(Integer id){
        return productService.findById(id);
    }
}
