package services;

import data.model.Mail;
import dtos.requests.MailResponse;
import dtos.requests.RegisterRequest;

import java.util.List;

public interface MailServices {
    Mail createMail(MailResponse response);

    Mail findById(int id);

    void deleteAllMail(Mail mail);

    void deleteById(int id);

    List<Mail> findAllMail();

    List<Mail> createMailFolder(String folderName);









}
