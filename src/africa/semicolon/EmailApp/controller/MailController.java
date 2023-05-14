package controller;

import dtos.requests.MailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.MailServices;
import services.MailServicesImpl;

@RestController
public class MailController {
    @Autowired
    private MailServices mailServices;

    @PostMapping("/mail/create")
    public ResponseEntity<?> createMail(@RequestBody MailRequest request){
        try {
            return new ResponseEntity<>(mailServices.createMail(request), HttpStatus.CREATED);
        }
        catch(IllegalArgumentException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
    @GetMapping("/mail/find/{id}")
    public ResponseEntity<?> findMailById(@PathVariable String id){
        try{
            return new ResponseEntity<>(mailServices.findById(id), HttpStatus.FOUND);
        }
        catch(IllegalArgumentException | NullPointerException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/mails")
    public ResponseEntity<?> findAllMail(){
        try{
            return new ResponseEntity<>(mailServices.findAllMail(), HttpStatus.FOUND);
        }
        catch (IllegalArgumentException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/mail/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id){
        try{
           return  new ResponseEntity<>(mailServices.deleteById(id), HttpStatus.FOUND);
        }catch (IllegalArgumentException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/mail/count")
    public ResponseEntity<?> countMail(){
        try {
            return new ResponseEntity<>(mailServices.count(), HttpStatus.OK);
        }catch (IllegalArgumentException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
}
