package africa.semicolon.EmailApp.responses;

import africa.semicolon.EmailApp.data.model.Mail;
import lombok.Data;

@Data
public class FindFolderResponse {
    private String id;
    private String name;
    private Mail mail;
}
