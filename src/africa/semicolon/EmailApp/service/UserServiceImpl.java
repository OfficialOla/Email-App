package africa.semicolon.EmailApp.service;

import africa.semicolon.EmailApp.data.model.Mail;
import africa.semicolon.EmailApp.data.model.MailFolder;
import africa.semicolon.EmailApp.data.model.User;
import africa.semicolon.EmailApp.data.repositories.MailFolderRepository;
import africa.semicolon.EmailApp.data.repositories.UserRepository;
import africa.semicolon.EmailApp.dtos.requests.LoginRequest;
import africa.semicolon.EmailApp.dtos.requests.RegisterRequest;
import africa.semicolon.EmailApp.dtos.responses.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import africa.semicolon.EmailApp.utils.Mapper;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
   @Autowired
   private MailFolderService mailFolderService;
    @Autowired
    private UserRepository userRepository;
//    List<User> users = new ArrayList<>();

    @Override
    public User register(RegisterRequest registerRequest) {
        if (userExist(registerRequest.getUsername()))
            throw new IllegalArgumentException(registerRequest.getUsername() + "already exist");
        if (userEmailExist(registerRequest.getEmailAddress()))
            throw new IllegalArgumentException(registerRequest.getEmailAddress() + "already exist");
        User user = Mapper.map(registerRequest);
        mailFolderService.createNewFolder(registerRequest.getEmailAddress());
        return userRepository.save(user);
    }

    private boolean userEmailExist(String emailAddress) {
        User foundUser = userRepository.findByEmailAddress(emailAddress);
        if (foundUser != null) return true;
        return false;
    }

    @Override
    public User findId(String id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    @Override
    public long count() {
        return userRepository.count();
    }

    @Override
    public void deleteAllMail(Mail mail) {
        userRepository.deleteAll();
    }

    @Override
    public List<User> findAll() {
       return userRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        userRepository.deleteById(id);
    }

//    @Override
//    public Object login(String emailAddress, String password) {
//        if (isValidEmail(emailAddress)) {
//            throw new IllegalArgumentException("Invalid email address");
//        }
//        User foundUser = userRepository.findByEmailAddress(emailAddress);
//        if (foundUser == null){
//            throw new IllegalArgumentException("You have to register to use this service");
//        }
//        if (!foundUser.getPassword().equals(password)){
//            throw new IllegalArgumentException("Incorrect password");
//        }else {
//            return "Login successful";
//        }
//    }

    public boolean isValidEmail(String emailStr) {
        String regex = "^[\\w-\\.+]*[\\w-\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return emailStr.matches(regex);
    }

    private boolean userExist(String username) {
        User foundUser = userRepository.findByUsername(username);
        if (foundUser != null) return true;
        return false;
    }

    @Override
    public User findByEmailAddress(String emailAddress) {
        return userRepository.findByEmailAddress(emailAddress);
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {

        return null;
    }

}