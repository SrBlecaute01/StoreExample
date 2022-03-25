package br.com.blecaute.store.dto.order;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data @AllArgsConstructor
public class OrderCreateDTO {

    @NotNull(message = "The user cannot be null")
    private Long userId;

    @NotNull(message = "The address cannot be null")
    private Long addressId;

    @NotEmpty(message = "The products cannot be empty")
    private Set<Long> products;

}
