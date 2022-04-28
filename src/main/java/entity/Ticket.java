package entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Ticket extends BaseEntity<Integer> {
    private String fullName;
    private String destination;
    private String origin;
    private Date dateOfDeparture;
    private Timestamp leavingHour;
    private Integer travelId;
    private Integer ticketId;
    @ManyToOne
    private Customer customer;

    @Override
    public String toString() {
        return "Ticket{" +
                "fullName='" + fullName + '\'' +
                ", destination='" + destination + '\'' +
                ", origin='" + origin + '\'' +
                ", dateOfDeparture=" + dateOfDeparture +
                ", leavingHour=" + leavingHour +
                ", travelId=" + travelId +
                ", ticketId=" + ticketId +
                ", customer=" + customer +
                '}';
    }
}
