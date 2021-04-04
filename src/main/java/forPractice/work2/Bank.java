package forPractice.work2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bank_table")
public class Bank {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "bank_serial_number")
    private int serialNumber;

    @Column (name = "country")
    private String bankCountry;

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", bankName='" + bankName + '\'' +
                ", serialNumber=" + serialNumber +
                ", bankCountry='" + bankCountry + '\'' +
                '}';
    }
}
