package Practice.springboot.employe;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService
{

    private JavaMailSender emailSender;

    public void EmailSenderService(JavaMailSender emailSender)
    {
        this.emailSender = emailSender;
    }

    public void sendEmail(String mailId)
    {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom( "angeltheinnovator@gmail.com" );
        message.setTo("angeltheinnovator@gmail.com");
        message.setSubject("You are enrolled successfully" );
        message.setText( "Hello, " + mailId + "!" );

        emailSender.send(message);
    }

}
