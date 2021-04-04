package example3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //getter, setter, setter, constructors
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private String email;
    private String country;
}
