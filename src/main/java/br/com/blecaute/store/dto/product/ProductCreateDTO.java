package br.com.blecaute.store.dto.product;

import br.com.blecaute.store.model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Data
@AllArgsConstructor
public class ProductCreateDTO {

    @NotNull(message = "The category cannot be null")
    private Long category;

    @NotNull(message = "The name cannot be null")
    private String name;

    @NotNull(message = "The description cannot be null")
    private String description;

    private String image;

    @PositiveOrZero(message = "The price cannot be negative")
    private Double price;

}
