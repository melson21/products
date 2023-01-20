package com.example.first.controller;

import com.example.first.model.Products;
import com.example.first.repository.ProductRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

@RestController
public class ProductsController {

    private ProductRepository productRepository;

    @Autowired
    public ProductsController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/json")
    public void json(){
        URL url = this.getClass().getClassLoader().getResource("products.json");

        if(url!=null){
            File jsonFile = new File(url.getFile());

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            try {
                List<Products> products = objectMapper.readValue(jsonFile, new TypeReference<List<Products>>(){});

                productRepository.saveAll(products);

            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println();
        } else{
            System.out.println("Failed");
        }
    }
}
