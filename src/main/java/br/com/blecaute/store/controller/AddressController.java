package br.com.blecaute.store.controller;

import br.com.blecaute.store.dto.address.AddressCreateDTO;
import br.com.blecaute.store.dto.address.AddressDTO;
import br.com.blecaute.store.dto.address.AddressUpdateDTO;
import br.com.blecaute.store.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/address")
public class AddressController {

    private AddressService service;

    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> findById(@PathVariable long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping("/{id}")
    public ResponseEntity<AddressDTO> create(@PathVariable long id, @Valid @RequestBody AddressCreateDTO address) {
        return new ResponseEntity<>(service.save(id, address), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressDTO> update(@PathVariable long id,@RequestBody AddressUpdateDTO address) {
        return ResponseEntity.ok(service.update(id, address));
    }

}
