package br.com.blecaute.store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
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
    @ToString.Exclude
    private Set<Address> address = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    @ToString.Exclude
    private List<Order> orders;

}
