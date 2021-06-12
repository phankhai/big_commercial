package com.example.big_commercial.controller;

import com.example.big_commercial.config.BadRequestException;
import com.example.big_commercial.config.EmailException;
import com.example.big_commercial.config.ProductNotfoundException;
import com.example.big_commercial.constant.ErrorConstants;
import com.example.big_commercial.entity.Product;
import com.example.big_commercial.enums.ErrorCodeMap;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("test")
public class HelloController {

    private static Map<String, Product> productRepo = new HashMap<>();
    static {
        Product honey = new Product();
        honey.setId("1");
        honey.setName("Honey");
        productRepo.put(honey.getId(), honey);

        Product almond = new Product();
        almond.setId("2");
        almond.setName("Almond");
        productRepo.put(almond.getId(), almond);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
        if(!productRepo.containsKey(id)) throw new BadRequestException(ErrorCodeMap.FAILURE_PRODUCT_NOT_FOUND.name());
        productRepo.remove(id);
        product.setId(id);
        productRepo.put(id, product);
        return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<Map<String, Product>> getAllProducts() {
        return new ResponseEntity<>(productRepo, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("")
    public String hello() {
        return "hello";
    }


}
