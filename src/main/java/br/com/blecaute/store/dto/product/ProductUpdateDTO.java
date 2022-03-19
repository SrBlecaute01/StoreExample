package br.com.blecaute.store.dto.product;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductUpdateDTO {

    private Long category;
    private String name;
    private String description;
    private String image;
    private Double price;

}
