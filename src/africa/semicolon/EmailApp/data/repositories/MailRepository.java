package africa.semicolon.EmailApp.data.repositories;

import africa.semicolon.EmailApp.data.model.Mail;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MailRepository extends MongoRepository<Mail, String> {
//    List<Mail> findAlleMails();
//    List<Mail> findByOutbox();
//
//    List<Mail> findByDraft();
//    List<Mail> findByTrash();

//    List<Mail> findByInbox();


//    List<Mail> getOutbox();
}
