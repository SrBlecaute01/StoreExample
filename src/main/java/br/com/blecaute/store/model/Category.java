package br.com.blecaute.store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "store_category")
public class Category {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "The name cannot be null")
    @Column(nullable = false, unique = true)
    private String name;

    @NotNull(message = "The date cannot be null")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date createdAt;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    @ToString.Exclude
    private List<Product> products;

}
