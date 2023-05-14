package africa.semicolon.EmailApp.service;

import africa.semicolon.EmailApp.data.model.Mail;
import africa.semicolon.EmailApp.dtos.requests.SendEmailRequest;

import java.util.List;

public interface MailService {
    Mail createNewEmail(SendEmailRequest response);

    Mail findById(String  id);

    void deleteAllMail(Mail mail);

    boolean deleteById(String id);

    List<Mail> findAllMail();
    long count();

    List<Mail> createMailFolder(String folderName);
//    List<Mail> viewAllMails();
    List<Mail> viewOutbox();
    List<Mail> viewDrafts();
    List<Mail> viewTrash();


}
