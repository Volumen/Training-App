package pl.pawpam.engineeringproject.email;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import pl.pawpam.engineeringproject.training.Training;
import pl.pawpam.engineeringproject.training.TrainingService;
import pl.pawpam.engineeringproject.training.TrainingServiceInterface;
import pl.pawpam.engineeringproject.user.User;
import pl.pawpam.engineeringproject.user.UserService;
import pl.pawpam.engineeringproject.user.UserServiceInterface;
import pl.pawpam.engineeringproject.utilities.UserUtilities;

@Aspect
//@Component
public class Email {

    private JavaMailSender javaMailSender;
    private UserServiceInterface userService;
    private TrainingServiceInterface trainingService;

    @Autowired
    public Email(JavaMailSender javaMailSender, UserServiceInterface userService, TrainingServiceInterface trainingService) {
    this.javaMailSender = javaMailSender;
    this.userService = userService;
    this.trainingService = trainingService;

    }

    @After(value = "@annotation(EmailAspect)")
    public void sendEmail()
    {
        Training training = trainingService.getLastTraining();
        String username = UserUtilities.getLoggedUser();
        User user = userService.findUserByEmail(username);
        SimpleMailMessage smm = new SimpleMailMessage();
        smm.setTo(username);
        smm.setSubject("Congratulations "+user.getName()+ "! You finished your workout! ");
        smm.setText("You finished "+training.getTrainingName() +"!\n"
                + "Exercises: " + training.getExerciseList() +"\n"
                + "Sets: " + training.getSets() +"\n"
                + "Level of training: "+training.getLevel() +"\n"
                + "You needed "+training.getFullTimeOfTraining()+"second to finished this workout!");
        javaMailSender.send(smm);
    }
}
