//package africa.semicolon.EmailApp.controller;
//
//import africa.semicolon.EmailApp.dtos.requests.SendEmailRequest;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//import africa.semicolon.EmailApp.service.MailService;
//
//@RestController
//@Slf4j
//@Validated
//@RequestMapping("/mail")
//public class MailController {
//    @Autowired
//    private MailService mailServices;
//
//
//    @PostMapping("/create")
//    public ResponseEntity<?> createNewMail(@RequestBody SendEmailRequest request){
//        try {
//            log.info("-----> Controller come here {}", request);
//            return new ResponseEntity<>(mailServices.createNewEmail(request), HttpStatus.CREATED);
//        }
//        catch(IllegalArgumentException ex){
//            return new ResponseEntity<>(ex.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
//        }
//    }
//    @GetMapping("/{id}")
//    public ResponseEntity<?> findMailById(@PathVariable String id){
//        try{
//            log.info("-----> Request for a single mail Controller comes here");
//            return new ResponseEntity<>(mailServices.findById(id), HttpStatus.FOUND);
//        }
//        catch(IllegalArgumentException | NullPointerException ex){
//            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
//        }
//
//    }
//    @GetMapping("/mails")
//    public ResponseEntity<?> findAllMail(){
//        try{
//            log.info("-----> find All mail request Controller comes here");
//            return new ResponseEntity<>(mailServices.findAllMail(), HttpStatus.FOUND);
//        }
//        catch (IllegalArgumentException ex){
//            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
//        }
//    }
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<?> deleteById(@PathVariable String id){
//        try{
//            log.info("-----> delete request for a single mail Controller comes here");
//           return  new ResponseEntity<>(mailServices.deleteById(id), HttpStatus.FOUND);
//        }catch (IllegalArgumentException ex){
//            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
//        }
//    }
//    @GetMapping("/count")
//    public ResponseEntity<?> countMail(){
//        try {
//            log.info("-----> Request to count all mail Controller comes here");
//            return new ResponseEntity<>(mailServices.count(), HttpStatus.OK);
//        }catch (IllegalArgumentException ex){
//            return new ResponseEntity<>(ex.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
//        }
//    }
//    @GetMapping("/mail/outbox/{id}")
//    public ResponseEntity<?> viewOutbox(@PathVariable String id){
//        try{
//            return  new ResponseEntity<>(mailServices.viewOutbox(), HttpStatus.FOUND);
//        }catch (IllegalArgumentException ex){
//            return  new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
//        }
//    }
////    @GetMapping("/mail/inbox/{id}")
////    public ResponseEntity<?> viewInbox(@PathVariable String id){
////        return new ResponseEntity<>(mailServices.)
////    }
//}
