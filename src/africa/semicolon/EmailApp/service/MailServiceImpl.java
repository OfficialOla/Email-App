package africa.semicolon.EmailApp.services;

import africa.semicolon.EmailApp.data.model.Mail;
import africa.semicolon.EmailApp.data.repositories.MailRepository;
import africa.semicolon.EmailApp.dtos.requests.MailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import africa.semicolon.EmailApp.utils.Mapper;

import java.util.List;

@Service
public class MailServicesImpl implements MailServices{
    @Autowired
    UserServices userServices;
    @Autowired
    MailRepository mailRepository;
    @Override
    public Mail createNewEmail(MailRequest request) {
        checkAdminExistsFrom(request);
        Mail mail = new Mail();
        Mapper.mapMailRequestToMail(request, mail);
       return mailRepository.save(mail);
    }
    private void checkAdminExistsFrom(MailRequest response){
        try{
            userServices.findId(response.getAuthorId());
        }catch (IllegalArgumentException ex){
            throw new IllegalArgumentException(String.format("Author with Id %s does not exist", response.getAuthorId()));
        }
    }

    @Override
    public Mail findById(String id) {
        return mailRepository.findById(id).get();

    }

    @Override
    public void deleteAllMail(Mail mail) {
        mailRepository.deleteAll();
    }

    @Override
    public boolean deleteById(String id) {
    mailRepository.deleteById(id);
    return true;
    }

    @Override
    public List<Mail> findAllMail() {
        return mailRepository.findAll();
    }

    @Override
    public long count() {
        return mailRepository.count();
    }

    @Override
    public List<Mail> createMailFolder(String folderName) {
        return null;
    }
}
