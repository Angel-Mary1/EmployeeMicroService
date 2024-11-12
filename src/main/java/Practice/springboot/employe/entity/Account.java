package Practice.springboot.employe.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="account_number")
    private Long accountNumber;

    @Column(name="accoun_holder")
    private String accounHolder;

    @Column(name="balance")
    private Integer balance;
}
