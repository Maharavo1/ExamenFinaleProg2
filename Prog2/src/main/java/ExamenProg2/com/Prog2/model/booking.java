package ExamenProg2.com.Prog2.model;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
@EqualsAndHashCode
@AllArgsConstructor
@Getter
@Setter
@ToString
public class booking {
    private int booking_id;
    private int customer_id;
    private int projection_id;
    private int room_id;
    private int number_of_reserved_places;
    private LocalDate date;
    private Float paiment_status;


}
