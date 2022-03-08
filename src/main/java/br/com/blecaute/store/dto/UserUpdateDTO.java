package br.com.blecaute.store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateDTO {

    @Null
    @NotBlank
    private String name;

    @Null
    @Email
    private String email;

    @Null
    @Size(min = 3, max = 16, message = "The password must be between 3 and 16 characters long")
    private String password;
}
