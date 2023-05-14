package africa.semicolon.EmailApp.dtos.requests;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class MailRequest {
    private String senderName;
    private String recipientEmailAddress;
    private String subject;
    private String message;
    private String authorId;
    private List<String> attachments;
    private LocalDateTime timeCreated = LocalDateTime.now();

}
