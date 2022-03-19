package br.com.blecaute.store.controller;

import br.com.blecaute.store.dto.product.ProductCreateDTO;
import br.com.blecaute.store.dto.product.ProductUpdateDTO;
import br.com.blecaute.store.model.Product;
import br.com.blecaute.store.service.ProductService;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private ProductService service;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> findAll() {
        return service.findAll();
    }

    @JsonView(Product.View.ExcludedCategory.class)
    @GetMapping("/category/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> findByCategory(@PathVariable long id) {
        return service.findByCategory(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product findById(@PathVariable long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@Valid @RequestBody ProductCreateDTO product) {
        return service.save(product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable long id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product update(@PathVariable long id, @Valid @RequestBody ProductUpdateDTO product) {
        return service.update(id, product);
    }

}
