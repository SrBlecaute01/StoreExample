package br.com.blecaute.store.model;

import com.fasterxml.jackson.annotation.JsonView;
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

    @JsonView(View.ExcludedCategory.class)
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "The category cannot be null")
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @JsonView(View.ExcludedCategory.class)
    @NotNull(message = "The name cannot be null")
    @Column(nullable = false)
    private String name;

    @JsonView(View.ExcludedCategory.class)
    @NotNull(message = "The description cannot be null")
    @Lob
    @Column(nullable = false)
    private String description;

    @JsonView(View.ExcludedCategory.class)
    private String image;

    @JsonView(View.ExcludedCategory.class)
    @PositiveOrZero(message = "The price cannot be negative")
    @Column(nullable = false)
    private Double price;

    @JsonView(View.ExcludedCategory.class)
    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date createdAt;

    public static class View {

        public interface ExcludedCategory {}

    }

}
