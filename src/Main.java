import controller.MailController;
import controller.UserController;
import dtos.requests.MailResponse;
import dtos.requests.RegisterRequest;

import javax.swing.*;

public class Main {
    private static UserController userController = new UserController();
    private static MailController mailController = new MailController();
    private static MailResponse mailResponse = new MailResponse();
    private static RegisterRequest registerRequest = new RegisterRequest();

    public static void main(String[] args) {
        startApp();
    }
    private static void startApp() {
        String message = """
                Hi, welcome...
                1 -> Register
                2 -> Login
                3 -> Find user
                4 -> Exit
                """;
        String input = input(message);
        switch (input.charAt(0)){
            case '1' -> register();
            case '2' -> login();
            case '3' -> findUser();
            case '4' ->exitApplication();
            default -> {
                display("invalid input try again");
                startApp();;
            }
        }

           }

    private static void homePage(){
        String message = """
                Welcome, """ +
                 registerRequest.getEmailAddress() +
                 """
                
                1 -> Compose Mail
                2 -> Sent Mails
                3 -> View mail by ID
                4 -> Inbox
                5 -> Delete mail by ID
                6 -> Delete all
                7 -> Log out
                """;
        String input = input(message);
        switch (input.charAt(0)){
            case '1' -> createMail();
            case '2' -> findAllSent();
            case '3' -> findById();
            case '4' -> viewInbox();
            case '5' -> deleteById();
            case '6' -> deleteAll();
            case '7' ->logout();
            default -> {
                display("invalid input try again");
                homePage();
            }
        }

    }
    private static void findUser() {
        String userId = input("Enter user ID to search for");
        display(userController.findUserById(Integer.parseInt(userId)).toString());

    }

    private static void deleteAll() {
    }

    private static void deleteById() {
        String mailId = input("Enter mail ID to delete");
        display(mailController.deleteById(Integer.parseInt(mailId)));
        homePage();
    }

    private static void viewInbox() {
    }

    private static void findById() {
        String mailId = input("Enter mail ID to search for");
        display(mailController.findById(Integer.parseInt(mailId)).toString());
        homePage();

    }

    private static void findAllSent() {
      display(mailController.findAllMail().toString());
        homePage();

    }

    private static void logout() {
        display("Log out successfully");
        startApp();
    }
    private static void login() {
        registerRequest.setEmailAddress(input("Enter email address"));
        registerRequest.setPassword(input("Enter password"));
        var result = userController.register(registerRequest);
        display("Login successful");
        homePage();
    }

    private static void createMail() {
        mailResponse.setMailTitle(input("Enter Title"));
        mailResponse.setMailBody(input("Enter message"));
        mailResponse.setRecipientName(input("Enter recipient name"));
        mailResponse.setRecipientEmailAddress(input("Enter recipient email address"));
        mailResponse.setSenderName(input("Enter sender's name"));
        mailResponse.setTimeCreated(mailResponse.getTimeCreated());
        
        var result = mailController.createMail(mailResponse);
        display(result.toString());
        display("Email successfully sent");
        homePage();
    }

    private static void register() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName(input("Enter first name"));
        registerRequest.setLastName(input("Enter Last name"));
        registerRequest.setUsername(input("Enter Username "));
        registerRequest.setEmailAddress(input("Enter email address"));
        registerRequest.setPassword(input("Enter password"));
        var result = userController.register(registerRequest);
        display(result.toString());
        startApp();

    }

    private static void exitApplication() {
        System.exit(0);
    }
    private static String input(String prompt) {
        return JOptionPane.showInputDialog(prompt);
    }
    private static void display(String message){
        JOptionPane.showMessageDialog(null, message);
    }

}