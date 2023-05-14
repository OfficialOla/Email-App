package africa.semicolon.EmailApp.dtos.requests;

import lombok.Data;

@Data
public class RegisterRequest {
    private String userId;
    private String firstName;
    private String lastName;
    private String username;
    private String emailAddress;
    private String password;

}
