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

    @Size(min = 3, max = 16, message = "The password must be between 3 and 16 characters long")
    private String password;
}
