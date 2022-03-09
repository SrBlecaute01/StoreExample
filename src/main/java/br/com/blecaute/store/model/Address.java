package br.com.blecaute.store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "store_address")
public class Address {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "The number cannot be null")
    @Positive(message = "The number must be positive")
    @Column(nullable = false)
    private Long number;

    @Pattern(regexp = "^\\d{5}\\-\\d{3}?$", message = "Invalid postal code format")
    @Column(nullable = false)
    private String code;

    private String complement;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    @ToString.Exclude
    private User user;
}
