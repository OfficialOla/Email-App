package controller;

import dtos.requests.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.UserServices;
import services.UserServicesImpl;

import java.util.InputMismatchException;

@RestController
public class UserController {
    @Autowired
    private UserServices userServices;

    @PostMapping("/user/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest){
        try {
            return new ResponseEntity<>(userServices.register(registerRequest), HttpStatus.CREATED);
        }
        catch (IllegalArgumentException | InputMismatchException | NullPointerException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/user/find/{id}")
    public  ResponseEntity<?> findUserById(@PathVariable String id){
        try{
            return new ResponseEntity<>(userServices.findId(id), HttpStatus.FOUND);
        }
        catch (NullPointerException | NumberFormatException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
