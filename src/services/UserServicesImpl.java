package services;

import data.model.User;
import data.repositories.UserRepository;
import data.repositories.UserRepositoryImpl;
import dtos.requests.MailResponse;
import dtos.requests.RegisterRequest;
import utils.Mapper;

public class UserServicesImpl implements UserServices {
    private UserRepository userRepository = new UserRepositoryImpl();

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
    public User findId(int id) {
        return userRepository.findById(id);
    }

    private boolean userExist(String username) {
        User foundUser = userRepository.findByUsername(username);
        if (foundUser != null) return true;
        return false;
    }
}

