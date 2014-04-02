/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domein;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author Shmoopsy
 */
public class Email 
{
    public void KeurGoed(String email) {

        final String username = "stefdieu1@gmail.com";
        final String password = "1234test";

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("stefdieu1@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(email));
            message.setSubject("Goed Keuring stage plaats");
            message.setText("Beste,"
                + "\n\n Hierbij wil ik u mededelen dat uw stageplaats is goedgekeurd "
                    + "\n en zal toegevoegd worden aan de lijst waaruit studenten kunnen kiezen"
                    + "\n\n mvg,"
                    + "\n\n\n Het StageTeam");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void KeurAf(String email, String rede){
        final String username = "stefdieu1@gmail.com";
        final String password = "1234test";

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("stefdieu1@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(email));
            message.setSubject("Af keuring stage plaats");
            message.setText("Beste,"
                + "\n\n Hierbij wil ik u mededelen dat uw stageplaats is afgekeurd "
                    + "\n en dit omwille van de hieronder volgende rede:"
                    + "\n" + rede
                    + "\n\n mvg,"
                    + "\n\n\n Het StageTeam");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    
}
