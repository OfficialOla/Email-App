package services;

import data.model.Mail;
import dtos.requests.MailResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class MailServicesImplTest {
    private MailServices mailServices;
    private RegisterRequest registerRequest;
    private MailResponse mailResponse;

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
        Mail savedMail = mailServices.createMail(mailResponse);
        assertTrue(savedMail.getMailId() != 0);
    }


}