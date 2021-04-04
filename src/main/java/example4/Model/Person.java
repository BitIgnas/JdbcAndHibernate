package example4.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(
                name = "get_person_by_name",
                query = "from Person where firstName like :name"
        )
})
@Entity //nurpdome, kad is sios klases kurisime duomenu bazes lentele
@Table (schema = "person") //optional, jei norite pakeisti duomenu bazes lenteles pavadinima
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id //pazymi, kad stulpelis priamry key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //nurodome generavimo strategijos tipa
    @Column(name = "id") //optional, reikalina pakeisti stulpelio pavadinima, ar dydi
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String country;
}
