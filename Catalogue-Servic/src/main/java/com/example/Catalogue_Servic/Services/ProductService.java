package com.example.Catalogue_Servic.Services;

import com.example.Catalogue_Servic.Model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProductService {

    Product createProduct(Product product);

    Product updateProduct(Long id, Product product);

    void deleteProduct(Long id);

    Optional<Product> getProductById(Long id);

    Page<Product> getAllProducts(Pageable pageable);

    Page<Product> searchProductsByName(String name, Pageable pageable);

    Page<Product> getProductsByCategory(String category, Pageable pageable);
}
