package oneToMany;

import lombok.*;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CART" )
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long cartId;

    @OneToMany(mappedBy = "cart")
    private Set<Item> items;

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                '}';
    }
}
