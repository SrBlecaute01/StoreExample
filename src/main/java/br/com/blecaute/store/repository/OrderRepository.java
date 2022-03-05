package br.com.blecaute.store.repository;

import br.com.blecaute.store.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> { }
