package com.example.big_commercial.controller;

import com.example.big_commercial.config.BadRequestException;
import com.example.big_commercial.entity.Test;
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

    private static Map<String, Test> productRepo = new HashMap<>();
    static {
        Test honey = new Test();
        honey.setId("1");
        honey.setName("Honey");
        productRepo.put(honey.getId(), honey);

        Test almond = new Test();
        almond.setId("2");
        almond.setName("Almond");
        productRepo.put(almond.getId(), almond);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Test product) {
        if(!productRepo.containsKey(id)) throw new BadRequestException(ErrorCodeMap.FAILURE_PRODUCT_NOT_FOUND.name());
        productRepo.remove(id);
        product.setId(id);
        productRepo.put(id, product);
        return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<Map<String, Test>> getAllProducts() {
        return new ResponseEntity<>(productRepo, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("")
    public String hello() {
        return "hello";
    }


}
