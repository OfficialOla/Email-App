package africa.semicolon.EmailApp.controller;

import africa.semicolon.EmailApp.Exceptions.UserExistException;
import africa.semicolon.EmailApp.data.model.MailFolder;
import africa.semicolon.EmailApp.dtos.requests.SendEmailRequest;
import africa.semicolon.EmailApp.service.MailFolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MailFolderController  {
    @Autowired
    MailFolderService mailFolderService;

    @PostMapping("/mail/send")
    public ResponseEntity<?> sendMail(@RequestBody SendEmailRequest sendEmailRequest){
        try{
            return new ResponseEntity<>(mailFolderService.sendMail(sendEmailRequest), HttpStatus.CREATED);
        }catch (IllegalArgumentException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
    @GetMapping("/mail/{id}")
    public ResponseEntity<?> findMailById(@PathVariable String id){
        try{
            return new ResponseEntity<>(mailFolderService.findById(id), HttpStatus.FOUND);
        }catch (IllegalArgumentException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/inbox/{emailAddress}")
    public ResponseEntity<?> findInbox(@PathVariable String emailAddress) {
        try{
            return new ResponseEntity<>(mailFolderService.findInbox(emailAddress), HttpStatus.FOUND);
        }catch (UserExistException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/outbox/{emailAddress}")
    public ResponseEntity<?> findOutbox(@PathVariable String emailAddress){
        try{
            return new ResponseEntity<>(mailFolderService.findOutbox(emailAddress), HttpStatus.FOUND);
        }catch(UserExistException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
