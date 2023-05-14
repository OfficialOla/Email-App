package africa.semicolon.EmailApp.services;

import africa.semicolon.EmailApp.data.model.Mail;
import africa.semicolon.EmailApp.dtos.requests.MailRequest;

import java.util.List;

public interface MailServices {
    Mail createNewEmail(MailRequest response);

    Mail findById(String  id);

    void deleteAllMail(Mail mail);

    boolean deleteById(String id);

    List<Mail> findAllMail();
    long count();

    List<Mail> createMailFolder(String folderName);


}
