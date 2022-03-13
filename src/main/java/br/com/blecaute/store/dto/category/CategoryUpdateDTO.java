package br.com.blecaute.store.dto.category;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class CategoryUpdateDTO {

    private String name;
    private Date createdAt;

}
