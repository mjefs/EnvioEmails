import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.junit.jupiter.api.Test;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.text.Document;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class SendEmail {

    private String email = "raram360@gmail.com";
    private String senha = "raram3602024";

    private String listaDestinatarios = "";
    private String nomeRemetente = "";
    private String assuntoEmail = "";
    private String mensagemEmail = "";

    public SendEmail(String email, String nomeRemetente, String assuntoEmail, String mensagemEmail) {
        this.email = email;
        this.nomeRemetente = nomeRemetente;
        this.assuntoEmail = assuntoEmail;
        this.mensagemEmail = mensagemEmail;

    }


    @Test
    public void enviarEmail(boolean envioHtml){
        Properties properties = new Properties();

        /*Paramêtros para conexão com Gmail*/

        /*
                properties.put("mail.smtp.ssl.trust", "*");
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.host", "smtp.live.com");
        properties.put("mail.smtp.socketFactory.port", "25");
        properties.put("mail.smtp.socketFactory.fallback", "false");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "25");
        */

        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.socketFactory.port","465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");



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
            message.setFrom(new InternetAddress(email,nomeRemetente));
            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject(assuntoEmail);

            if(envioHtml){
                message.setContent(mensagemEmail, "test/html; charset=utf-8");
            }else {
                message.setText(mensagemEmail);
            }

            Transport.send(message);

            /*Gerador de PDF, em um ambiente normal buscariamos isso no banco de dados*/
            private FileInputStream simuladorDePdf() throw Exception{
                Document document = new Document();
                File file =  new File("fileanexo.pdf");
                file.createNewFile();
                PdfWriter.getInstance(document, new FileOutputStream(file));
                document.open();
                document.add(new Paragraph(assuntoEmail));
                document.close;

                return new FileInputStream(file);
            }

            System.out.println("Mensagem enviada com sucesso!");


        } catch (Exception e) {
            throw new RuntimeException(e);
        }



    }

}