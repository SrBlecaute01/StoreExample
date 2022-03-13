package br.com.blecaute.store.dto.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
public class CategoryCreateDTO {

    @NotNull(message = "The name cannot be null")
    private String name;
    private Date createdAt;
    
}