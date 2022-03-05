package br.com.blecaute.store.repository;

import br.com.blecaute.store.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> { }
