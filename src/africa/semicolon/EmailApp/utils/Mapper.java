package africa.semicolon.EmailApp.utils;

import africa.semicolon.EmailApp.data.model.Mail;
import africa.semicolon.EmailApp.data.model.User;
import africa.semicolon.EmailApp.dtos.requests.SendEmailRequest;
import africa.semicolon.EmailApp.dtos.requests.RegisterRequest;

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
    public static void mapMailRequestToMail(SendEmailRequest response, Mail mail){
        mail.setMailBody(response.getMessage());
        mail.setMailTitle(response.getSubject());
//        mail.setTimeCreated(response.getTimeCreated());
        mail.setSenderName(response.getSenderName());
        mail.setRecipientEmailAddress(response.getRecipientEmail().toString());
    }
}
