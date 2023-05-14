package africa.semicolon.EmailApp.service;

import africa.semicolon.EmailApp.Exceptions.UserExistException;
import africa.semicolon.EmailApp.data.model.Mail;
import africa.semicolon.EmailApp.data.model.MailFolder;
import africa.semicolon.EmailApp.dtos.requests.SendEmailRequest;

import java.util.List;

public interface MailFolderService {

    MailFolder createNewFolder(String email);

    Object sendMail(SendEmailRequest sendEmailRequest);
    MailFolder findById(String  id);

    void deleteAllFolders();

    boolean deleteById(String id);

    List<MailFolder> findAllMailFolder();

    long count();

    List<Mail> findInbox(String emailAddress) throws UserExistException;

    List<Mail> findOutbox(String emailAddress) throws UserExistException;


}
