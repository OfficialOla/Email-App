package africa.semicolon.EmailApp.controller;

import africa.semicolon.EmailApp.dtos.requests.LoginRequest;
import africa.semicolon.EmailApp.dtos.requests.RegisterRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import africa.semicolon.EmailApp.service.UserService;

import java.util.InputMismatchException;

@RestController
@Slf4j
//@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

  @PostMapping("/user/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest){
        try {
            log.info("-----> Controller comes here {}", registerRequest);
            return new ResponseEntity<>(userService.register(registerRequest), HttpStatus.CREATED);
        }
        catch (IllegalArgumentException | InputMismatchException | NullPointerException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/user/{id}")
    public  ResponseEntity<?> findUserById(@PathVariable String id){
        try{
            log.info("-----> Request for a single user Controller come here");
            return new ResponseEntity<>(userService.findId(id), HttpStatus.FOUND);
        }
        catch (NullPointerException | NumberFormatException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/user/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            return new ResponseEntity<>(userService.login(loginRequest), HttpStatus.OK);
        } catch (IllegalArgumentException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/users")
    public ResponseEntity<?> findAll(){
        try{
            return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
        }catch (IllegalArgumentException ex){
            return  new ResponseEntity<>(ex.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
}
