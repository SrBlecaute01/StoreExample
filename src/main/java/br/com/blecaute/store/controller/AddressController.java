package br.com.blecaute.store.controller;

import br.com.blecaute.store.dto.address.AddressCreateDTO;
import br.com.blecaute.store.dto.address.AddressDTO;
import br.com.blecaute.store.dto.address.AddressUpdateDTO;
import br.com.blecaute.store.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/address")
public class AddressController {

    private AddressService service;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AddressDTO findById(@PathVariable long id) {
        return service.findById(id);
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public AddressDTO create(@PathVariable long id, @Valid @RequestBody AddressCreateDTO address) {
        return service.save(id, address);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable long id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AddressDTO update(@PathVariable long id,@RequestBody AddressUpdateDTO address) {
        return service.update(id, address);
    }

}
