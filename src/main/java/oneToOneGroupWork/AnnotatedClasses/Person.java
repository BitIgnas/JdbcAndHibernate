package oneToOneGroupWork.AnnotatedClasses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "person")
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Person {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String country;

    @OneToOne
    @JoinColumn(name = "phone_id", unique = true)
    private Phone phone;

}
