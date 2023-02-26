package dtos.requests;

import java.time.LocalDateTime;

public class MailResponse {
    private String senderName;
    private String recipientName;

    private String recipientEmailAddress;

    private String mailTitle;

    private String mailBody;

    private LocalDateTime timeCreated = LocalDateTime.now();

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientEmailAddress() {
        return recipientEmailAddress;
    }

    public void setRecipientEmailAddress(String recipientEmailAddress) {
        this.recipientEmailAddress = recipientEmailAddress;
    }

    public String getMailTitle() {
        return mailTitle;
    }

    public void setMailTitle(String mailTitle) {
        this.mailTitle = mailTitle;
    }

    public String getMailBody() {
        return mailBody;
    }

    public void setMailBody(String mailBody) {
        this.mailBody = mailBody;
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(LocalDateTime timeCreated) {
        this.timeCreated = timeCreated;
    }

    @Override
    public String toString() {
        return "Mail{" +
                ", senderName='" + senderName + '\'' +
                ", recipientName='" + recipientName + '\'' +
                ", receiverEmailAddress='" + recipientEmailAddress + '\'' +
                ", mailTitle='" + mailTitle + '\'' +
                ", mailBody='" + mailBody + '\'' +
                ", timeCreated=" + timeCreated +
                '}';
    }
}
