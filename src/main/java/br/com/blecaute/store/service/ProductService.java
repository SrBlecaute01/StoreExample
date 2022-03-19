package br.com.blecaute.store.service;

import br.com.blecaute.store.dto.product.ProductCreateDTO;
import br.com.blecaute.store.dto.product.ProductUpdateDTO;
import br.com.blecaute.store.exception.product.ProductNotFoundException;
import br.com.blecaute.store.model.Product;
import br.com.blecaute.store.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;
    private CategoryService categoryService;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> findByCategory(long id) {
        return categoryService.findById(id).getProducts();
    }

    public Product findById(long id) {
        return productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
    }

    public Product save(ProductCreateDTO dto) {
        final var category = categoryService.findById(dto.getCategory());
        final var product = Product.builder()
                .name(dto.getName())
                .category(category)
                .description(dto.getDescription())
                .image(dto.getImage())
                .price(dto.getPrice())
                .createdAt(new Date())
                .build();

        return productRepository.save(product);
    }

    public void delete(long id) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException();
        }

        productRepository.deleteById(id);
    }

    public Product update(long id, ProductUpdateDTO dto) {
        final var product = findById(id);

        final var category = dto.getCategory();
        if (category != null) {
            product.setCategory(categoryService.findById(category));
        }

        final var name = dto.getName();
        if (name != null) {
            product.setName(name);
        }

        final var description = dto.getDescription();
        if (description != null) {
            product.setDescription(description);
        }

        final var price = dto.getPrice();
        if (price != null && price >= 0) {
            product.setPrice(price);
        }

        final var image = dto.getImage();
        if (image != null) {
            product.setImage(image);
        }

        return productRepository.save(product);
    }

}
