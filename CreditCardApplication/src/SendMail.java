import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

class SendingMail
{
    static String eid;
    static  long pinnumber;
    static long cdno;
    static long formno;

    SendingMail(String emailid, long pin, long cardno, long fno)
    {
        eid = emailid;
        pinnumber = pin;
        cdno = cardno;
        formno = fno;
    }

    static Properties properties = new Properties();
    static {
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
    }

    public void email()
    {
        String returnStatement = null;
        try {
            Authenticator auth = new Authenticator() {
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("miniprojectcard@gmail.com", "amitdeepak");
                }
            };
            Session session = Session.getInstance(properties, auth);
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("miniprojectcard@gmail.com"));
            //message.setRecipient(Message.RecipientType.TO, new InternetAddress(eid));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress("deepakjaiswal.18cs@saividya.ac.in"));
            message.setSentDate(new Date());
            message.setSubject("Registration Confirmation Email.");
            message.setText("Dear Customer,\nThank You For Registering With Us.\nYour Form Number Is: "+formno+"\nPlease Use The Following Credentials For Your Next Login.\nCard Number: "+cdno+"\nDefault Pin:" + pinnumber + ".\nPlease Generate New Pin On Your First Login.\nThank You.");
            returnStatement = "The E-Mail Was Sent Successfully";
            System.out.println(returnStatement);
            Transport.send(message);
        } catch (Exception e) {
            returnStatement = "Error In Sending E-Mail";
            e.printStackTrace();
        }
    }
}
