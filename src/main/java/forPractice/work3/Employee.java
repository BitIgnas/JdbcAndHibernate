package forPractice.work3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;


@Entity
@Table(name = "employee")
@Data @NoArgsConstructor @AllArgsConstructor
public class Employee {
    @Id
    @Column(name = "employee_id")
    private Long id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "salary")
    private int salary;



}
