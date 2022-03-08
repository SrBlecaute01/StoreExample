package br.com.blecaute.store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateDTO {

    @NotBlank(message = "Invalid name")
    private String name;

    @Email(message = "Invalid email")
    private String email;

    @Min(value = 3, message = "The password must be a minimum of 3 characters")
    @Max(value = 16, message = "The password must be a maximum of 16 characters")
    private String password;
}
