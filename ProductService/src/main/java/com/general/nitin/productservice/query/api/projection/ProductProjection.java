package com.general.nitin.productservice.query.api.projection;

import com.general.nitin.productservice.commands.api.data.entity.Product;
import com.general.nitin.productservice.commands.api.data.repository.ProductRepository;
import com.general.nitin.productservice.commands.api.model.ProductRestModel;
import com.general.nitin.productservice.query.api.queries.GetProductsQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductProjection {

    private ProductRepository productRepository;

    public ProductProjection(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @QueryHandler
    public List<ProductRestModel> handle(GetProductsQuery query) {

        List<Product> products = productRepository.findAll();

        return products.stream().map(product -> ProductRestModel
                        .builder()
                        .name(product.getName())
                        .quantity(product.getQuantity())
                        .price(product.getPrice())
                        .build())
                        .collect(Collectors.toList());
    }
}
