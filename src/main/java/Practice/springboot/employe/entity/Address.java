package Practice.springboot.employe.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table( name ="addr")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToOne
    private Teacher teacher;

    @Override
    public String toString() {
        return "Address [id=" + id + ", name=" + name + ", teacher=" + teacher + "]";
    }

}
