package services;

import data.model.User;
import dtos.requests.MailResponse;
import dtos.requests.RegisterRequest;

public interface UserServices {
    User register(RegisterRequest registerRequest);

    User findId(int id);


}
