package africa.semicolon.EmailApp.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document
public class MailFolder {
    @Id
    private String id;
    private String emailAddress;
    private List<Mail> mails;
    private List<Mail> inbox = new ArrayList<>();
    private List<Mail> outbox = new ArrayList<>();
    private List<Mail> drafts = new ArrayList<>();

    public List<Mail> getInbox() {
        return inbox;
    }

    public void setInbox(Mail inbox){
        this.inbox.add(inbox);
    }

    public List<Mail> getOutbox() {
        return outbox;
    }

    public void setOutbox(Mail outbox) {
        this.outbox.add(outbox);
    }

    public List<Mail> getDrafts() {
        return drafts;
    }

    public void setDrafts(Mail drafts) {
        this.drafts.add(drafts);
    }
}
