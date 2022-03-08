package br.com.blecaute.store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateDTO {

    @Min(value = 3, message = "The name must be a minimum of 3 characters")
    private String name;

    @NotNull
    @Email(message = "Invalid email")
    private String email;

    @NotNull
    @Min(value = 3, message = "The password must be a minimum of 3 characters")
    @Max(value = 16, message = "The password must be a maximum of 16 characters")
    private String password;
}
