package africa.semicolon.EmailApp.dtos.responses;

import lombok.Data;

@Data
public class FindUserResponse {
    private String userId;
    private String username;
    private String fullName;
    private String dateRegistered;
}
