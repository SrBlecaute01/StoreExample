package br.com.blecaute.store.dto.user;

import br.com.blecaute.store.model.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private long id;

    private String name;
    private String email;
    private Date createdAt;

    private Set<Address> address;
}