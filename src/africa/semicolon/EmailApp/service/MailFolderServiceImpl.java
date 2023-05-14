package africa.semicolon.EmailApp.service;

import africa.semicolon.EmailApp.Exceptions.UserExistException;
import africa.semicolon.EmailApp.data.model.Mail;
import africa.semicolon.EmailApp.data.model.MailFolder;
import africa.semicolon.EmailApp.data.model.User;
import africa.semicolon.EmailApp.data.repositories.MailFolderRepository;
import africa.semicolon.EmailApp.dtos.requests.SendEmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MailFolderServiceImpl implements MailFolderService{
    @Autowired
    MailFolderRepository mailFolderRepository;

//    @Autowired
//    UserService userService;

    @Override
    public MailFolder createNewFolder(String email) {
        MailFolder mailFolder = new MailFolder();
        mailFolder.setEmailAddress(email);
        return mailFolderRepository.save(mailFolder);
    }

    @Override
    public Object sendMail(SendEmailRequest sendEmailRequest) {
        Mail mail = new Mail();
        mail.setMailTitle(sendEmailRequest.getSubject());
        mail.setMailBody(sendEmailRequest.getMessage());
        mail.setSenderEmail(sendEmailRequest.getSenderEmail());
        mail.setRecipientEmailAddress(sendEmailRequest.getRecipientEmail());
        MailFolder sender = mailFolderRepository.findByEmailAddress(sendEmailRequest.getSenderEmail());
        MailFolder recipient = mailFolderRepository.findByEmailAddress(sendEmailRequest.getRecipientEmail());
        sender.setOutbox(mail);
        recipient.setInbox(mail);
        mailFolderRepository.save(sender);
        mailFolderRepository.save(recipient);
        return "Email sent successfully";
    }

    @Override
    public MailFolder findById(String id) {
        return mailFolderRepository.findById(id).get();
    }

    @Override
    public void deleteAllFolders() {
        mailFolderRepository.deleteAll();
    }


    @Override
    public boolean deleteById(String id) {
        mailFolderRepository.deleteById(id);
        return true;
    }

    @Override
    public List<MailFolder> findAllMailFolder() {
        return mailFolderRepository.findAll();
    }

    @Override
    public long count() {
        return mailFolderRepository.count();
    }

    @Override
    public List<Mail> findInbox(String emailAddress) throws UserExistException {
        MailFolder mailFolder = mailFolderRepository.findByEmailAddress(emailAddress);
        if (emailAddress == null) throw new UserExistException("Email Address does not exist");
        return mailFolder.getInbox();
    }

    @Override
    public List<Mail> findOutbox(String emailAddress) throws UserExistException{
        MailFolder mailFolder = mailFolderRepository.findByEmailAddress(emailAddress);
        if (emailAddress == null) throw new UserExistException("Email Address does not exist");
        return mailFolder.getOutbox();
    }
}
