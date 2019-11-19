package pl.pawpam.engineeringproject.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.pawpam.engineeringproject.email.EmailAspect;

import java.util.List;

@Service
public class TrainingService {

    private TrainingRepository trainingRepository;

    @Autowired
    public TrainingService(@Qualifier("trainingRepository") TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }
    public List<Training> getTrainings()
    {
        return trainingRepository.findAll();
    }
    @EmailAspect
    public void sendMail()
    {
        System.out.println("Mail został wysłany");

    }
}
