package br.com.blecaute.store.repository;

import br.com.blecaute.store.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {

    Optional<Address> findByIdAndUserId(Long id, Long user_id);

}
