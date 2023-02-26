package controller;

import dtos.requests.MailResponse;
import services.MailServices;
import services.MailServicesImpl;

public class MailController {
    private MailServices mailServices = new MailServicesImpl();

    public Object createMail(MailResponse response){
        try {
            return mailServices.createMail(response);
        }
        catch(IllegalArgumentException ex){
            return ex.getMessage();
        }
    }
    public Object findMailById(int id){
        try{
            return mailServices.findById(id);
        }
        catch(IllegalArgumentException ex){
            return ex.getMessage();
        }
    }
    public Object findAllMail(){
        try{
            return mailServices.findAllMail();
        }
        catch (IllegalArgumentException ex){
            return ex.getMessage();
        }
    }
    public  Object findById(int id){
        try{
            return mailServices.findById(id);
        }
        catch (NullPointerException | NumberFormatException ex){
            return ex.getMessage();
        }
    }
    public String deleteById(int id){
        try{
            mailServices.deleteById(id);
        }catch (NullPointerException | NumberFormatException ex){
            return ex.getMessage();
        }

        return "Mail deleted";
    }
}
