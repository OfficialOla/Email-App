package africa.semicolon.EmailApp.dtos.responses;

import lombok.Data;

@Data
public class FindMailResponse {
    private  String mailId;
    private String recipientName;
    private String recipientEmailAddress;
    private String mailTitle;
    private String mailBody;
}
