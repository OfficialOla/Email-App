package africa.semicolon.EmailApp.dtos.requests;

import lombok.Data;

@Data
public class MailFolderRequest {
    private String emailAddress;
    private String username;
    private String password;
}
