package com.general.nitin.productservice.query.api.controller;

import com.general.nitin.productservice.commands.api.model.ProductRestModel;
import com.general.nitin.productservice.query.api.queries.GetProductsQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductQueryController {

    private final QueryGateway queryGateway;

    public ProductQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping
    public List<ProductRestModel> getProducts() {
        GetProductsQuery getProductsQuery = new GetProductsQuery();

        return queryGateway
                .query(getProductsQuery,
                        ResponseTypes.multipleInstancesOf(ProductRestModel.class))
                .join();
    }
}
