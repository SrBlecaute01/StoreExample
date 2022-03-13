package br.com.blecaute.store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "store_address")
public class Address {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "^\\d{5}\\-\\d{3}?$", message = "Invalid postal code format")
    @Column(nullable = false)
    private String code;

    @NotNull(message = "The street cannot be null")
    @Column(nullable = false)
    private String street;

    @NotNull(message = "The number cannot be null")
    @Positive(message = "The number must be positive")
    @Column(nullable = false)
    private Long number;

    private String complement;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    @ToString.Exclude
    private User user;
}
