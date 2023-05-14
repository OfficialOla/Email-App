package data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Data
@Document
public class Mail {
    @Id
    private  String mailId;
    private String senderName;
    private String recipientName;
    private String recipientEmailAddress;
    private String mailTitle;
    private String mailBody;
    private String authorId;
    private LocalDateTime timeCreated = LocalDateTime.now();

}
