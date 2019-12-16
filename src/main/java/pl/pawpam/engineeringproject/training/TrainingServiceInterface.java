package pl.pawpam.engineeringproject.training;


import java.util.List;

public interface TrainingServiceInterface {
    void sendMail();
    void saveTraining(Training training);
    Training getLastTraining();
    List<Training> getTrainings();


}
