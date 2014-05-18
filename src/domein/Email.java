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
    public void KeurGoed(String email, String contact, String titel, String academiejaar) {

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
            message.setText("Geachte " + contact + ","
                + "\n\n Het ingediend voorstel van stage-opdracht met titel " + titel + " is goedgekeurd voor academiejaar "+ academiejaar + "."
                    + "\n\n Dit wil zeggen dat uw stage-opdracht in de lijst van goedgekeurde stages aan de studenten zal worden getoond"
                    + "\n\n Indien er studenten geïnteresseerd zijn in uw stage, dan zullen zij contact met uw bedrijf opnemen om te solliciteren."
                    + "\n\n Alvast veel succes met de sollicitaties en nogmaals hartelijk dank voor het indienen van uw stage-opdracht."
                    + "\n\n Met vriendelijke groeten,"
                    + "\n\n Anneleen Bekkens"
                    + "\n Lector Informatica"
                    + "\n Stagecoördinator Toegepaste Informatica");

            Transport.send(message);

           

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void KeurAf(String email, String rede, String contact, String titel, String academiejaar){
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
            message.setText("Geachte " + contact + ","
                + "\n\n Het ingediend voorstel van stage-opdracht met titel " + titel + " is niet goedgekeurd voor academiejaar " +academiejaar +"."
                    + "\n\n Reden hiervoor is: " + rede
                    + "\n\n Met vriendelijke groeten,"
                    + "\n\n Anneleen Bekkens"
                    + "\n Lector Informatica"
                    + "\n Stagecoördinator Toegepaste Informatica");

            Transport.send(message);

           
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    
}
