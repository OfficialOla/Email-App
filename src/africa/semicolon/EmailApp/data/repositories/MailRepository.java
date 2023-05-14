package data.repositories;

import data.model.Mail;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MailRepository extends MongoRepository<Mail, String> {


}
