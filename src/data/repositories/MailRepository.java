package data.repositories;

import data.model.Mail;

import java.util.List;

public interface MailRepository {
    Mail save(Mail mail);

    Mail findById(int id);

    long count();

    List<Mail> findAll();

    void delete(int id);

    void deleteAll();

    Mail findByReceiverName(String receiverName);






}
