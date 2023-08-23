package ExamenProg2.com.Prog2.model;

import lombok.*;

@EqualsAndHashCode
@AllArgsConstructor
@Getter
@Setter
@ToString
public class room {
    private int room_id;
    private String name;
    private int capacity;
}
