package controller;

import dtos.requests.MailResponse;
import dtos.requests.RegisterRequest;
import services.UserServices;
import services.UserServicesImpl;

import java.util.InputMismatchException;

public class UserController {
    private UserServices userServices = new UserServicesImpl();
    public Object register(RegisterRequest registerRequest){
        try {
            return userServices.register(registerRequest);
        }
        catch (IllegalArgumentException | InputMismatchException | NullPointerException ex){
            return ex.getMessage();
        }
    }
    public  Object findUserById(int id){
        try{
            return userServices.findId(id);
        }
        catch (NullPointerException | NumberFormatException ex){
            return ex.getMessage();
        }
    }
}
