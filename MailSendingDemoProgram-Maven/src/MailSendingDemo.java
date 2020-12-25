import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Before sending mail, First enable SMTP from your gmail settings.
 * Also, disable less secure app feature from your google account.
 * Now you are ready to send mail from this program.
 */


public class MailSendingDemo
{
    static Properties properties = new Properties();
    static {
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
    }
    public static void main(String[] args) {
        String returnStatement = null;
        try {
            Authenticator auth = new Authenticator() {
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("deepakjaiswal.18cs@saividya.ac.in", "YOUR PASSWORD");
                }
            };
            Session session = Session.getInstance(properties, auth);
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("deepakjaiswal.18cs@saividya.ac.in"));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress("deepakjaiswal1950@gmail.com"));
            message.setSentDate(new Date());
            message.setSubject("Test Mail");
            message.setText("Hi\nMail sent successfully!!!");
            returnStatement = "The e-mail was sent successfully";
            System.out.println(returnStatement);
            Transport.send(message);
        } catch (Exception e) {
            returnStatement = "error in sending mail";
            e.printStackTrace();
        }
    }
}
