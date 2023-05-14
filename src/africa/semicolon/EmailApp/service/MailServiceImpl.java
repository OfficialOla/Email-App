//package africa.semicolon.EmailApp.service;
//
//import africa.semicolon.EmailApp.data.model.Mail;
//import africa.semicolon.EmailApp.data.model.User;
//import africa.semicolon.EmailApp.data.repositories.MailRepository;
//import africa.semicolon.EmailApp.dtos.requests.SendEmailRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import africa.semicolon.EmailApp.utils.Mapper;
//
//import java.util.List;
//
//@Service
//public class MailServiceImpl implements MailService {
//    @Autowired
//    UserService userServices;
//
//    @Autowired
//    MailRepository mailRepository;
//    @Override
//    public Mail createNewEmail(SendEmailRequest request) {
////        checkAdminExistsFrom(request);
////        checkSenderEmailExist(request);
////        checkRecipientEmailExist(request);
////        Mail mail = new Mail();
////        Mapper.mapMailRequestToMail(request, mail);
////        if (sendMail(request)){
////            mailRepository.findByOutbox().add(mail);
////        }else {
////            mailRepository.findByDraft().add(mail);
////        }
//////        userServices.findByEmailAddress(request.getRecipientEmail());
////
//////        EmailSender.sendMail(request);
//       return mailRepository.save(mail);
//    }
//
//    private void checkRecipientEmailExist(SendEmailRequest request) {
//        try{
//            userServices.findByEmailAddress(request.getRecipientEmail());
//        }catch (IllegalArgumentException ex) {
//            throw new IllegalArgumentException(String.format("Recipient's mail %s does not exist", request.getRecipientEmail()));
//        }
//    }
//
//    private void checkSenderEmailExist(SendEmailRequest request) {
//        try{
//            userServices.findByEmailAddress(request.getSenderEmail());
//        } catch (IllegalArgumentException ex){
//            throw new IllegalArgumentException(String.format("Sender's email %s does not exist", request.getSenderEmail()));
//        }
//    }
//
//    private void checkAdminExistsFrom(SendEmailRequest response){
//        try{
//            userServices.findId(response.getAuthorId());
//        }catch (IllegalArgumentException ex){
//            throw new IllegalArgumentException(String.format("Author with Id %s does not exist", response.getAuthorId()));
//        }
//    }
//
//    @Override
//    public Mail findById(String id) {
//        return mailRepository.findById(id).get();
//    }
//    @Override
//    public void deleteAllMail(Mail mail) {
//        mailRepository.deleteAll();
//    }
//
//    @Override
//    public boolean deleteById(String id) {
//    mailRepository.deleteById(id);
//    return true;
//    }
//
//    @Override
//    public List<Mail> findAllMail() {
//        return mailRepository.findAll();
//    }
//
//    @Override
//    public long count() {
//        return mailRepository.count();
//    }
//
//    @Override
//    public List<Mail> createMailFolder(String folderName) {
//        return null;
//    }
//
////    @Override
////    public List<Mail> viewAllMails() {
////        return mails;
////    }
//
//    @Override
//    public List<Mail> viewOutbox() {
//        return mailRepository.findByOutbox();
//    }
//
//    @Override
//    public List<Mail> viewDrafts() {
//        return mailRepository.findByDraft();
//    }
//
//    @Override
//    public List<Mail> viewTrash() {
//        return mailRepository.findByTrash();
//    }
//
//    public boolean sendMail(SendEmailRequest request){
//        User recipient = userServices.findByEmailAddress(request.getRecipientEmail());
//        User sender = userServices.findByEmailAddress(request.getSenderEmail());
//
//        Mail mail = new Mail();
//        mail.setMailBody(request.getMessage());
//        mail.setMailTitle(request.getSubject());
//        mail.setSenderName(request.getSenderName());
//        mail.setSenderEmail(request.getSenderEmail());
//        return false;
//    }
//
//}
