package br.com.blecaute.store.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.Instant;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @NotNull
    @Email(message = "Invalid email")
    @Column(unique = true, nullable = false)
    private String email;

    @NotNull
    @Min(value = 3, message = "The password must be a minimum of 3 characters")
    @Max(value = 16, message = "The password must be a maximum of 16 characters")
    @Column(nullable = false, length = 16)
    private String password;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Instant createdAt;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Instant lastLogin;

    @OneToMany(mappedBy = "user")
    private Set<Address> address;

}
