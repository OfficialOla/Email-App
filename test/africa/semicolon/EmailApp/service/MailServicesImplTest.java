package africa.semicolon.EmailApp.service;

import africa.semicolon.EmailApp.data.model.Mail;
import africa.semicolon.EmailApp.dtos.requests.SendEmailRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class MailServicesImplTest {
    private MailService mailServices;
    private RegisterRequest registerRequest;
    private SendEmailRequest mailResponse;

    private Mail mail;
    @BeforeEach
    public void setMail(){
        mailServices = new MailServiceImpl();
        mail = new Mail();
        mailResponse.setMessage("Election is tomorrow");
        mailResponse.setSubject("Election update");
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