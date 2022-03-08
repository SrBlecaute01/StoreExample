package br.com.blecaute.store.repository;

import br.com.blecaute.store.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> { }
