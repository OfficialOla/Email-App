package data.repositories;

import data.model.Mail;

import java.util.ArrayList;
import java.util.List;

public class MailRepositoryImpl implements MailRepository{
    public int count = 0;

    public List<Mail> mails = new ArrayList<>();

    @Override
    public Mail save(Mail mail) {
        boolean userHasNotBeenSaved = mail.getMailId() ==0;
        if (userHasNotBeenSaved) saveNew(mail);
        return mail;
    }

    private void saveNew(Mail mail) {
        mail.setMailId(generateMailId());
       mails.add(mail);
        count++;
    }

    private int generateMailId() {
        return count + 1;
    }

    @Override
    public Mail findById(int id) {
        for (Mail mail: mails) if (mail.getMailId() == id) {return mail;
        }
        else throw new NullPointerException("Mail not found");
        return null;
    }

    @Override
    public long count() {
        return count;
    }

    @Override
    public List<Mail> findAll() {
        return null;
    }

    @Override
    public void delete(int id) {
        for (Mail mail: mails) {
            boolean userHasNotBeenSaved = mail.getMailId() == id;
            if (userHasNotBeenSaved) {
                mails.remove(mail);
                count--;
                break;
            }
        }

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Mail findByReceiverName(String receiverName) {
        for (Mail mail : mails) {
            if (mail.getRecipientName().equalsIgnoreCase(receiverName)) {
                return mail;
            }
            else throw new NullPointerException("Receiver's name not found");
        }
        return null;
    }
    }
