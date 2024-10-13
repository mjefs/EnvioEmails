import org.junit.Test;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class App {

    @Test
    public void test() throws Exception {

      StringBuilder stringBuilderTextoEmail = new StringBuilder();
      stringBuilderTextoEmail.append("Ol[a, <br/><br/>");
      stringBuilderTextoEmail.append("Você está recebendo acesso ao curso de Java <br/><br/>");
      stringBuilderTextoEmail.append("<a target=\"_blank\" href=\"https://projetojavaweb.com\" style=\"color:#2525a7; padding: 14px 25px; text-align: center; text-decoration: none\">Acessar portal do ALuno.</a");

      SendEmail enviaEmail =
              new SendEmail("raram360@gmail.com",
                      "Master Jefs",
                      "Meu e-mail com Java",
                      stringBuilderTextoEmail.toString());

      enviaEmail.enviarEmail(true);

    }

}
