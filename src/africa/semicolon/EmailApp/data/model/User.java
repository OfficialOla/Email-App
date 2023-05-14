package data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Data
@Document
public class User {
    @Id
    private String userId;
    private String firstName;
    private String lastName;
    private String username;
    private String emailAddress;
    private String password;
    private LocalDateTime dateRegistered = LocalDateTime.now();

}
