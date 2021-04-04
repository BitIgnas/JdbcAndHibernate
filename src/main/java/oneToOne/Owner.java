package oneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;

@Entity
@Table(name = "owner")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String country;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id", unique = true) //foreign key
    private Book book;

}
