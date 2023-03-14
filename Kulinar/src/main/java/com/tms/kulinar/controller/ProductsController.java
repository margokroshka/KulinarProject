package com.tms.kulinar.controller;

import com.tms.kulinar.domain.Products;
import com.tms.kulinar.domain.Users;
import com.tms.kulinar.repository.ProductsRepository;
import com.tms.kulinar.repository.UsersRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/products")
public class ProductsController {
    private final ProductsRepository productsRepository;

    @Autowired
    public ProductsController(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @Operation(description = "Ищет продукт по ID", summary = "Ищет продукт")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200", description = "Все ОК! Улыбаемся и машем"),
            @ApiResponse(responseCode = "404", description = "Куда ты жмал?!!? Ничего не нашел")
    })

    @GetMapping("/{id}")
    @Tag(name = "byID", description = "ищём по id")
    public ResponseEntity<Products> getProductsById(@PathVariable int id)  {
        Products products = productsRepository.getProductsById(id);
        return  new ResponseEntity<>(products,  HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ArrayList<Products>> getAllProducts() {
        return new ResponseEntity<>(productsRepository.getAllProducts(), HttpStatus.OK);
    }
}
