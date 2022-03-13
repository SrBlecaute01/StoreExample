package br.com.blecaute.store.service;

import br.com.blecaute.store.dto.category.CategoryCreateDTO;
import br.com.blecaute.store.dto.category.CategoryUpdateDTO;
import br.com.blecaute.store.exception.category.CategoryAlreadExistsException;
import br.com.blecaute.store.exception.category.CategoryNotFoundException;
import br.com.blecaute.store.model.Category;
import br.com.blecaute.store.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class CategoryService {

    private CategoryRepository repository;

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category findById(long id) {
        return repository.findById(id).orElseThrow(CategoryNotFoundException::new);
    }

    public Category findByName(String name) {
        return repository.findByName(name).orElseThrow(CategoryNotFoundException::new);
    }

    public Category save(CategoryCreateDTO dto) {
        if (repository.existsByName(dto.getName())) {
            throw new CategoryAlreadExistsException();
        }

        return repository.save(Category.builder()
                .name(dto.getName())
                .createdAt(Objects.requireNonNullElse(dto.getCreatedAt(), new Date()))
                .build());
    }

    public void delete(long id) {
        if (!repository.existsById(id)) {
            throw new CategoryNotFoundException();
        }

        repository.deleteById(id);
    }

    public Category update(long id, CategoryUpdateDTO dto) {
        final var category = repository.findById(id).orElseThrow(CategoryNotFoundException::new);
        final var name = dto.getName();
        final var date = dto.getCreatedAt();

        if (name != null) {
            category.setName(name);
        }

        if (date != null) {
            category.setCreatedAt(date);
        }

        return repository.save(category);
    }

}
