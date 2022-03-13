package br.com.blecaute.store.controller;

import br.com.blecaute.store.dto.user.UserCreateDTO;
import br.com.blecaute.store.dto.user.UserDTO;
import br.com.blecaute.store.dto.user.UserUpdateDTO;
import br.com.blecaute.store.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private UserService service;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO findById(@PathVariable long id) {
        return service.findById(id);
    }

    @GetMapping("/email/{email}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO findByEmail(@Email @PathVariable String email) {
        return service.findByEmail(email);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO create(@Valid @RequestBody UserCreateDTO user) {
        return service.save(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable long id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO update(@PathVariable long id, @Valid @RequestBody UserUpdateDTO user) {
        return service.update(id, user);
    }

}
