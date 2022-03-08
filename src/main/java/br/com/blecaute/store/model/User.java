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

    @NotBlank(message = "The name is invalid")
    @Column(nullable = false)
    private String name;

    @Email(message = "The email format is invalid")
    @Column(unique = true, nullable = false)
    private String email;

    @Size(min = 3, max = 16, message = "The password must be between 3 and 16 characters long")
    @Column(nullable = false)
    private String password;

    @NotNull(message = "The date is invalid")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date createdAt;

    @OneToMany(mappedBy = "user")
    private Set<Address> address;

}
