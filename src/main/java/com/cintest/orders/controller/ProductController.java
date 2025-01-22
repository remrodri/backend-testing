package com.cintest.orders.controller;

import com.cintest.orders.model.dto.CreateProductDto;
import com.cintest.orders.service.order.ProductService;
import com.cintest.orders.vo.ProductVo;
import com.cintest.orders.vo.StandarResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<StandarResponse> createProduct(@Valid @RequestBody CreateProductDto dto){
        System.out.println(dto);
        ProductVo vo = productService.createProduct(dto);
        StandarResponse response = StandarResponse
                .builder()
                .message("Producto creado correctamente")
                .data(vo)
                .build();
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<?>findAllProducts(){
        List<ProductVo> vos = productService.getProducts();
        StandarResponse response = StandarResponse
                .builder()
                .message("Productos obtenidos correctamente")
                .data(vos)
                .build();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

}
