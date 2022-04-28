package entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Customer extends BaseEntity<Integer> {
    private String fullName;
    @Column(nullable = false,unique = true)
    private String nationalCode;
    private String password;
    @OneToMany(mappedBy = "customer")
    private Set<Ticket> tickets;
    private String customerGender;

    public Customer(String nationalCode, String password) {
        this.nationalCode = nationalCode;
        this.password = password;
    }

    public Customer(String fullName, String nationalCode, String password, String customerGender) {
        this.fullName = fullName;
        this.nationalCode = nationalCode;
        this.password = password;
        this.customerGender = customerGender;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "fullName='" + fullName + '\'' +
                ", nationalCode='" + nationalCode + '\'' +
                ", password='" + password + '\'' +
                ", tickets=" + tickets +
                ", customerGender=" + customerGender +
                '}';
    }
}