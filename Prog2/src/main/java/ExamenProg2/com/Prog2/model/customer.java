package ExamenProg2.com.Prog2.model;

import lombok.*;

import java.util.Date;
@EqualsAndHashCode
@AllArgsConstructor
@Getter
@Setter
@ToString
public class customer {
    private int customer_id;
    private String name;
    private String first_name;
    private String adress;
    private String email;
    private String phone;
}
