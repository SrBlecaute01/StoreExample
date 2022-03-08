package br.com.blecaute.store.dto;

import br.com.blecaute.store.model.Address;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

public class UserDTO {

    @NotNull
    private long id;

    @NotNull
    private String name;

    @NotNull
    @Email(message = "Invalid email")
    private String email;

    @NotNull
    private Date createdAt;

    @NotNull
    private Date lastLogin;

    private Set<Address> address;
}
