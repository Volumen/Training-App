package pl.pawpam.engineeringproject.email;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import pl.pawpam.engineeringproject.user.UserService;
import pl.pawpam.engineeringproject.utilities.UserUtilities;

@Aspect
@Component
public class Email {

    private JavaMailSender javaMailSender;
    private UserService userService;

    @Autowired
    public Email(JavaMailSender javaMailSender, UserService userService ) {
    this.javaMailSender = javaMailSender;
    this.userService = userService;

    }

    @After(value = "@annotation(EmailAspect)")
    public void sendEmail()
    {
        String username = UserUtilities.getLoggedUser();

        SimpleMailMessage smm = new SimpleMailMessage();
        smm.setTo(username);
        smm.setSubject("Congratulations! You finished workout! ");
        smm.setText("sada");
        javaMailSender.send(smm);
    }
}
