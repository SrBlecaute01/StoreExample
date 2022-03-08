package br.com.blecaute.store.dto.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddressCreateDTO {

    @NotNull(message = "The number cannot be null")
    @Positive(message = "The number must be positive")
    private Long number;

    @Pattern(regexp = "^\\d{5}\\-\\d{3}?$", message = "Invalid postal code format")
    private String code;

    private String complement;
}
