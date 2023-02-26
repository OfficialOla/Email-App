package services;

import data.model.Mail;
import data.repositories.MailRepository;
import data.repositories.MailRepositoryImpl;
import dtos.requests.MailResponse;
import dtos.requests.RegisterRequest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MailServicesImpl implements MailServices{
    UserServices userServices = new UserServicesImpl();
    MailRepository mailRepository = new MailRepositoryImpl();
    @Override
    public Mail createMail(MailResponse response) {
        Mail mail = new Mail();
//        User savedUser = userServices.findId(mail.getMailId());
//        int identity = savedUser.getUserId();
        mail.setMailBody(response.getMailBody());
        mail.setMailTitle(response.getMailTitle());
        mail.setTimeCreated(response.getTimeCreated());
        mail.setSenderName(response.getSenderName());
        mail.setRecipientName(response.getRecipientName());
        mail.setRecipientEmailAddress(response.getRecipientEmailAddress());
//        mail.setSenderName(response.getSenderName());
//        mail.setMailId(identity);
        LocalDate dateTime = LocalDateTime.now().toLocalDate();
       return mailRepository.save(mail);
    }

    @Override
    public Mail findById(int id) {

        return mailRepository.findById(id);
    }

    @Override
    public void deleteAllMail(Mail mail) {

    }

    @Override
    public void deleteById(int id) {
    mailRepository.delete(id);
    }

    @Override
    public List<Mail> findAllMail() {
        ArrayList<Mail> allMails = new ArrayList<>();
    allMails.add((Mail) mailRepository.findAll());

        return allMails;
    }

    @Override
    public List<Mail> createMailFolder(String folderName) {
        return null;
    }
}
