package africa.semicolon.EmailApp.responses;

import lombok.Data;

@Data
public class FindMailResponse {
    private  String mailId;
    private String senderName;
    private String recipientName;
    private String recipientEmailAddress;
    private String mailTitle;
    private String mailBody;
    private String authorId;
}
