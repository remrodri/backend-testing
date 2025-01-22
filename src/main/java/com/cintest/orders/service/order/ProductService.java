package com.cintest.orders.service.order;

import com.cintest.orders.model.Entity.Product;
import com.cintest.orders.model.dto.CreateProductDto;
import com.cintest.orders.repository.IProductRepository;
import com.cintest.orders.vo.ProductVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    private final IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductVo> getProducts() {

        return List.of();
    }

    @Override
    public ProductVo createProduct(CreateProductDto dto) {
//        System.out.println(dto);
        Product product = new Product();
        product.setNumber(dto.number());
        product.setPName(dto.name());
        product.setPPrice(dto.price());

        Product productSaved = productRepository.save(product);

        return new ProductVo(
                productSaved.getId(),
                productSaved.getNumber(),
                productSaved.getPName(),
                productSaved.getPPrice()
        );
    }
}
