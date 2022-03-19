package br.com.blecaute.store.dto.product;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.PositiveOrZero;

@Data
@AllArgsConstructor
public class ProductUpdateDTO {

    private Long category;
    private String name;
    private String description;
    private String image;

    @PositiveOrZero(message = "The price cannot be negative")
    private Double price;

}
