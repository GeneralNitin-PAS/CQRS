package com.general.nitin.productservice.commands.api.data.repository;

import com.general.nitin.productservice.commands.api.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}
