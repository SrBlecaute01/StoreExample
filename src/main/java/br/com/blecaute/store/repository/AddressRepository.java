package br.com.blecaute.store.repository;

import br.com.blecaute.store.model.Address;
import br.com.blecaute.store.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> { }
