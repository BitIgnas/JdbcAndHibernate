package oneToOneGroupWork.AnnotatedClasses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;

@Entity
@Table(name = "phone")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Phone {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String manufacturer;

    @Column
    private String model;

    @OneToOne(mappedBy = "phone")
    Person person;

}
