package africa.semicolon.EmailApp.data.repositories;

import africa.semicolon.EmailApp.data.model.Mail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MailRepositoryImplTest {

    private MailRepository mailRepository;

    private Mail mail;

    @BeforeEach
    public void setMail(){
        mailRepository = new MailRepositoryImpl();
        mail = new Mail();
    }
    @Test public void saveOneMail_countIsOneTest(){
        mailRepository.save(mail);
        assertEquals(1, mailRepository.count());
    }
    @Test public void saveOneMail_IdOfMailIsOne(){
        Mail savedMail = mailRepository.save(mail);
        assertEquals(1, savedMail.getMailId());
    }

    @Test public void saveOneMail_findMailByIdTest(){
        Mail savedMail = mailRepository.save(mail);
        assertEquals(1, savedMail.getMailId());
        Mail foundMail = mailRepository.findById(1);
        assertEquals(foundMail, savedMail);
    }
    @Test public void saveOneMail_deleteOneMail_countIsZeroTest(){
        mailRepository.save(mail);
        assertEquals(1, mailRepository.count());
        mailRepository.delete(1);
        assertEquals(0, mailRepository.count());
    }


}