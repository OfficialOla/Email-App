package africa.semicolon.EmailApp.service;

import africa.semicolon.EmailApp.data.model.Mail;
import africa.semicolon.EmailApp.data.model.User;
import africa.semicolon.EmailApp.dtos.requests.LoginRequest;
import africa.semicolon.EmailApp.dtos.requests.RegisterRequest;
import africa.semicolon.EmailApp.dtos.responses.LoginResponse;

import java.util.List;

public interface UserService {
    User register(RegisterRequest registerRequest);

    User findId(String id);

    long count();
    void deleteAllMail(Mail mail);

    List<User> findAll();

    void deleteById(String id);
//    Object login(String username, String password);

    User findByEmailAddress(String emailAddress);
    LoginResponse login(LoginRequest loginRequest);




//    FindUserResponse findUser(String id);


}
