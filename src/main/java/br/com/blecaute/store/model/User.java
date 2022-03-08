package br.com.blecaute.store.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "store_user")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotNull
    @Email(message = "Invalid email")
    @Column(unique = true, nullable = false)
    private String email;

    @NotNull
    @Min(value = 3, message = "The password must be a minimum of 3 characters")
    @Max(value = 16, message = "The password must be a maximum of 16 characters")
    @Column(nullable = false)
    private String password;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date createdAt;

    @OneToMany(mappedBy = "user")
    private Set<Address> address;

}
