package utils;

import data.model.Mail;
import data.model.User;
import dtos.requests.MailRequest;
import dtos.requests.RegisterRequest;

public class Mapper {
    public static User map(RegisterRequest registerRequest) {
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
        user.setPassword(registerRequest.getPassword());
        user.setEmailAddress(registerRequest.getEmailAddress());
        return user;
    }
//    public  static void map(RegisterRequest registerRequest, User user){
//        user.setUsername(registerRequest.getUsername());
//        user.setFirstName(registerRequest.getFirstName());
//        user.setLastName(registerRequest.getLastName());
//        user.setPassword(registerRequest.getPassword());
//        user.setEmailAddress(registerRequest.getEmailAddress());
//        user.setDateOfBirth(registerRequest.getDateOfBirth());
//    }
    public static void mapMailRequestToMail(MailRequest response, Mail mail){
        mail.setMailBody(response.getMailBody());
        mail.setMailTitle(response.getMailTitle());
        mail.setTimeCreated(response.getTimeCreated());
        mail.setSenderName(response.getSenderName());
        mail.setRecipientName(response.getRecipientName());
        mail.setRecipientEmailAddress(response.getRecipientEmailAddress());
    }
}
