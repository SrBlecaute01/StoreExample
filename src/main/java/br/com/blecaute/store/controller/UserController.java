package br.com.blecaute.store.controller;

import br.com.blecaute.store.dto.UserCreateDTO;
import br.com.blecaute.store.dto.UserDTO;
import br.com.blecaute.store.dto.UserUpdateDTO;
import br.com.blecaute.store.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
@Validated
public class UserController {

    private UserService service;

    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserDTO> findByEmail(@Email @PathVariable String email) {
        return ResponseEntity.ok(service.findByEmail(email));
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@Valid @RequestBody UserCreateDTO user) {
        return new ResponseEntity<>(service.save(user), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable long id, @Valid @RequestBody UserUpdateDTO user) {
        return ResponseEntity.ok(service.update(id, user));
    }

}
