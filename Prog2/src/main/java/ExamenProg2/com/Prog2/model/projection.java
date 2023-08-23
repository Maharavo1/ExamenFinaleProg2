package ExamenProg2.com.Prog2.model;

import lombok.*;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

@EqualsAndHashCode
@AllArgsConstructor
@Getter
@Setter
@ToString
public class projection {
    private int projection_id ;
private int film_id;
private int room_id;
private LocalDate date;
private Time start_time ;
private int duration ;
}
