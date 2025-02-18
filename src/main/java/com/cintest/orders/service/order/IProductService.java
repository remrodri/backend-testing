package com.cintest.orders.service.order;

import com.cintest.orders.model.Entity.Product;
import com.cintest.orders.model.dto.CreateProductDto;
import com.cintest.orders.vo.ProductVo;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<ProductVo> getProducts();
    ProductVo createProduct(CreateProductDto dto);
    Optional<Product> findProductById(Long id);

}
