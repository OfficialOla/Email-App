package data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class MailFolder {
    @Id
    private String id;
    private String name;
    private List<Mail> mails;
}
