package com.sum.mail;


import org.junit.jupiter.api.Test;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class AppTest {

    private String email = "masterjefs@outlook.com";
    private String senha = "2001Xjtao";

    @Test
    public void testeEmail(){
        Properties properties = new Properties();

        /*Paramêtros para conexão com Gmail*/

        /*properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.socketFactory.port","465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); */

        properties.put("mail.smtp.ssl.trust", "*");
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.host", "smtp.live.com");
        properties.put("mail.smtp.socketFactory.port", "587");
        properties.put("mail.smtp.socketFactory.fallback", "false");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication()
                    {
                        return new PasswordAuthentication(email,
                                senha);
                    }
                });

        /* Ativa Debug para a sessão */
        session.setDebug(true);

        try {
            /*Remetente*/
            Address[] toUser = InternetAddress /*Destinatários*/
                    .parse("raram360@gmail.com, jefinhoyt013@gmai.com, masterjefs@outlook.com");

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email,"Master jefs"));
            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject("E-mail enviado do Java");
            message.setText("Chegou seu e-mail do Java");

            Transport.send(message);

            System.out.println("Mensagem enviada com sucesso!");


        } catch (Exception e) {
            throw new RuntimeException(e);
        }



    }

}