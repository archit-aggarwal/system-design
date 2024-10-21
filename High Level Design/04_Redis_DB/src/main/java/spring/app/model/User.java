package spring.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

// Redis Entity (No need of @Entity and @Table, Make it Serializable)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = -7817224776021728682L;

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String mobileNo;
}