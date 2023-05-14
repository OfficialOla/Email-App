package africa.semicolon.EmailApp.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
