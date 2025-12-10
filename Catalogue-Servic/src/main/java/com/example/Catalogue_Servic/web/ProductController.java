package com.example.Catalogue_Servic.web;

import com.example.Catalogue_Servic.Model.Product;
import com.example.Catalogue_Servic.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // -------------------------
    // CREATE (POST)
    // -------------------------
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product created = productService.createProduct(product);
        return ResponseEntity.ok(created);
    }

    // -------------------------
    // READ ONE (GET by ID)
    // -------------------------
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // -------------------------
    // READ ALL (GET) + pagination + search
    // -------------------------
    @GetMapping
    public Page<Product> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String name
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);

        // Si l'utilisateur cherche par nom
        if (name != null && !name.isEmpty()) {
            return productService.searchProductsByName(name, pageRequest);
        }

        // Sinon renvoie tous les produits
        return productService.getAllProducts(pageRequest);
    }

    // -------------------------
    // UPDATE (PUT)
    // -------------------------
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable Long id,
            @RequestBody Product product
    ) {
        try {
            Product updated = productService.updateProduct(id, product);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // -------------------------
    // DELETE (DELETE)
    // -------------------------
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
