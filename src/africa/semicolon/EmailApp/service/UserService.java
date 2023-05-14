package africa.semicolon.EmailApp.services;

import africa.semicolon.EmailApp.data.model.Mail;
import africa.semicolon.EmailApp.data.model.User;
import africa.semicolon.EmailApp.dtos.requests.RegisterRequest;

public interface UserServices {
    User register(RegisterRequest registerRequest);

    User findId(String id);

    long count();
    void deleteAllMail(Mail mail);

    void deleteById(String id);




//    FindUserResponse findUser(String id);


}
