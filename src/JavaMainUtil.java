import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class JavaMainUtil {

    public static void sendMail(String receiver) throws Exception{
        System.out.println("Preparing to send email");
        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host", "pop.gmail.com");
        properties.put("mail.smtp.port", "587");

        String myEmail = "upturncode@gmail.com";
        String password = "XXXXX";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myEmail, password);
            }
        });

        Message message = prepareMessage(session ,myEmail, receiver);
        Transport.send(message);
        System.out.println("Message sent successfully");
    }

    private static Message prepareMessage(Session session, String myEmail, String reciever){
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(reciever));
            message.setSubject("Email from program");
            message.setText("Test main from JAVA");
            return message;
        }catch (Exception e ){
            System.out.println("Error");
        };
        return null;
        };
}
