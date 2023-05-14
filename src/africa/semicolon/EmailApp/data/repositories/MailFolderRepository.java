package africa.semicolon.EmailApp.data.repositories;

import africa.semicolon.EmailApp.data.model.Mail;
import africa.semicolon.EmailApp.data.model.MailFolder;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MailFolderRepository extends MongoRepository<MailFolder, String> {
   MailFolder findByEmailAddress(String emailAddress);
}
