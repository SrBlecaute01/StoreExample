package br.com.blecaute.store.controller;

import br.com.blecaute.store.dto.category.CategoryCreateDTO;
import br.com.blecaute.store.dto.category.CategoryUpdateDTO;
import br.com.blecaute.store.model.Category;
import br.com.blecaute.store.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    private CategoryService service;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Category> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Category findById(@PathVariable long id) {
        return service.findById(id);
    }

    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Category findByName(@PathVariable String name) {
        return service.findByName(name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Category create(@Valid @RequestBody CategoryCreateDTO category) {
        return service.save(category);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable long id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Category update(@PathVariable long id, @Valid @RequestBody CategoryUpdateDTO category) {
        return service.update(id, category);
    }

}
