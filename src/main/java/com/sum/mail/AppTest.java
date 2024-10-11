package com.sum.mail;


import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

public class AppTest {

    @org.junit.Test
    public void testeEmail(){
        Properties properties = new Properties();

        /*Paramêtros para conexão com Gmail*/

        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.socketFactory.port","465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");

        Session session = Session.getInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("raram360@gmail.com",
                                "2001Xjtao");
                    }
                });

        /* Ativa Debug para a sessão */
        session.setDebug(true);



    }

}