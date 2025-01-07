package Practice.springboot.employe.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table( name="cutomer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="customerName")
    private String customerName;

    @Column(name="age")
    private String age;

   @OneToMany( targetEntity = Product.class, cascade = CascadeType.ALL)
    @JoinColumn( name="customer_id", referencedColumnName ="id")
    private List<Product> products;

}
