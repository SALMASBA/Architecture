package com.example.customerservice.repository;


import com.example.customerservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

// @RepositoryRestResource génère automatiquement :
// GET /api/customers
// POST /api/customers
// etc.
@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Permet de chercher un client pour l'email de notification
}