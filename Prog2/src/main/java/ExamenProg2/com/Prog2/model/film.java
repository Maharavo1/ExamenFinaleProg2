package ExamenProg2.com.Prog2.model;

import lombok.*;

@EqualsAndHashCode
@AllArgsConstructor
@Getter
@Setter
@ToString
public class film {
    private int film_id;
    private String title;
    private int duration;
    private String gender;
}
