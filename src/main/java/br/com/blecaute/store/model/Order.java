package br.com.blecaute.store.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "store_order")
public class Order {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "The status cannot be null")
    @Column(nullable = false)
    private OrderStatus status;
    
    @NotNull(message = "The user cannot be null")
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull(message = "The address cannot be null")
    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @NotNull(message = "The date cannot be null")
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date createdAt;

    @ToString.Exclude
    @ManyToMany
    @JoinTable(name = "store_order_products",
            joinColumns = @JoinColumn(name = "order_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "product_id", nullable = false))
    private List<Product> products;
}
