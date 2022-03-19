package br.com.blecaute.store.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "store_product")
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "The category cannot be null")
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @NotNull(message = "The name cannot be null")
    @Column(nullable = false)
    private String name;

    @NotNull(message = "The description cannot be null")
    @Lob
    @Column(nullable = false)
    private String description;

    private String image;

    @PositiveOrZero(message = "The price cannot be negative")
    @Column(nullable = false)
    private Double price;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date createdAt;

}
