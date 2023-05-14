package africa.semicolon.EmailApp.services;

import africa.semicolon.EmailApp.data.model.Mail;
import africa.semicolon.EmailApp.data.model.User;
import africa.semicolon.EmailApp.data.repositories.UserRepository;
import africa.semicolon.EmailApp.dtos.requests.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import africa.semicolon.EmailApp.utils.Mapper;

@Service
public class UserServicesImpl implements UserServices {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User register(RegisterRequest registerRequest) {
        if (userExist(registerRequest.getUsername()))
            throw new IllegalArgumentException(registerRequest.getUsername() + "already exist");
    if (userExist(registerRequest.getEmailAddress()))
        throw new IllegalArgumentException(registerRequest.getEmailAddress() + "already exist");
    return  userRepository.save(Mapper.map(registerRequest));
//    User user = new User();
//        Mapper.map(registerRequest);
//        return userRepository.save(user);

    }

    @Override
    public User findId(String id) {
        return userRepository.findById(id).orElseThrow(()->new IllegalArgumentException("User not found"));
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
    public void deleteById(String id) {
        userRepository.deleteById(id);
    }

    private boolean userExist(String username) {
        User foundUser = userRepository.findByUsername(username);
        if (foundUser != null) return true;
        return false;
    }
}

