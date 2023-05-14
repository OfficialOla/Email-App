package africa.semicolon.EmailApp.dtos.requests;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class SendEmailRequest {
    private String senderName;
//    private List<String> recipientEmail;
    private String recipientEmail;
    private String subject;
    private String message;
    private String authorId;
    private String password;
    private String senderEmail;
//    private LocalDateTime timeCreated = LocalDateTime.now();

}
