package com.example.Catalogue_Servic.web; // ⬅️ CORRIGÉ : Le package doit être le chemin complet

// Imports pour les annotations Spring GraphQL (assure-toi que la dépendance 'spring-boot-starter-graphql' est dans ton pom.xml)
import com.example.Catalogue_Servic.Model.Product;
import com.example.Catalogue_Servic.Services.ProductService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class ProductGraphQLController {

    // 1. Injection de Dépendance (IoC) du Service Métier
    private final ProductService productService;

    public ProductGraphQLController(ProductService productService) {
        this.productService = productService;
    }

    // ----------------------------------------------------
    // Implémentation des QUERIES (Lecture / GET)
    // Ces méthodes correspondent aux entrées de 'type Query' dans schema.graphqls
    // ----------------------------------------------------

    @QueryMapping // Mappe à la requête 'allProducts'
    public List<Product> allProducts() {
        return productService.getAllProducts(Pageable.unpaged()).getContent(); // Appelle la méthode findAll() du service
    }

    @QueryMapping // Mappe à la requête 'productById(id: ID!)'
    public Product productById(@Argument Long id) {
        return productService.getProductById(id).orElse(null); // Appelle la méthode findById() du service
    }

    @QueryMapping
    public List<Product> searchProducts(@Argument String name) {
        return productService.searchProductsByName(name, Pageable.unpaged()).getContent();
    }

    @QueryMapping
    public List<Product> productsByCategory(@Argument String category) {
        return productService.getProductsByCategory(category, Pageable.unpaged()).getContent();
    }

    // ----------------------------------------------------
    // Implémentation des MUTATIONS (Modification / POST, PUT, DELETE)
    // Ces méthodes correspondent aux entrées de 'type Mutation' dans schema.graphqls
    // ----------------------------------------------------

    @MutationMapping // Mappe à la mutation 'createProduct(...)'
    public Product createProduct(
            @Argument Long id,
            @Argument String name,
            @Argument String description,
            @Argument BigDecimal price,
            @Argument int stockQuantity) {

        // Crée l'objet Product
        Product newProduct = new Product();
        newProduct.setName(name);
        newProduct.setDescription(description);
        newProduct.setPrice(price);
        newProduct.setStock(stockQuantity);

        return productService.createProduct(newProduct);
    }

    @MutationMapping
    public Product updateProduct(
            @Argument Long id,
            @Argument String name,
            @Argument String description,
            @Argument BigDecimal price,
            @Argument int stockQuantity) {

        Product updated = new Product();
        updated.setName(name);
        updated.setDescription(description);
        updated.setPrice(price);
        updated.setStock(stockQuantity);

        return productService.updateProduct(id, updated);
    }

    @MutationMapping
    public Boolean deleteProduct(@Argument Long id) {
        try {
            productService.deleteProduct(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}