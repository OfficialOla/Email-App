package africa.semicolon.EmailApp.services;

import africa.semicolon.EmailApp.data.model.Mail;
import africa.semicolon.EmailApp.dtos.requests.MailRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class MailServicesImplTest {
    private MailServices mailServices;
    private RegisterRequest registerRequest;
    private MailRequest mailResponse;

    private Mail mail;
    @BeforeEach
    public void setMail(){
        mailServices = new MailServicesImpl();
        mail = new Mail();
        mailResponse.setMailBody("Election is tomorrow");
        mailResponse.setMailTitle("Election update");
        mailResponse.setRecipientName("John");
        mailResponse.setSenderName("Olayinka");
        mailResponse.setTimeCreated(LocalDateTime.now());



    }

    @Test
    public void mailIsCreated_countIsOneTest(){
        Mail savedMail = mailServices.createNewEmail(mailResponse);
        assertTrue(savedMail.getMailId() != 0);
    }


}