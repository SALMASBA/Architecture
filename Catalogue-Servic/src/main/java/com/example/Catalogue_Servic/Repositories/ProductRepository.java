package com.example.Catalogue_Servic.Repositories;

import com.example.Catalogue_Servic.Model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Permet de chercher des produits par nom (mot-clé)
    Page<Product> findByNameContainingIgnoreCase(String name, Pageable pageable);

    // Filtrer par catégorie
    Page<Product> findByCategory(String category, Pageable pageable);
}
