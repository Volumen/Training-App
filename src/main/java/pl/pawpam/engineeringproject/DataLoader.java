package pl.pawpam.engineeringproject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.pawpam.engineeringproject.training.Exercise;
import pl.pawpam.engineeringproject.training.ExerciseRepository;
import pl.pawpam.engineeringproject.training.Training;
import pl.pawpam.engineeringproject.training.TrainingRepository;

import java.util.*;

@Component
public class DataLoader implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(DataLoader.class);
    private ExerciseRepository exerciseRepository;
    private TrainingRepository trainingRepository;

    public DataLoader(ExerciseRepository exerciseRepository, TrainingRepository trainingRepository) {
        this.exerciseRepository = exerciseRepository;
        this.trainingRepository = trainingRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Loading Exercises and Trainings from DataLoader...");
        exerciseRepository.getExerciseList().add(new Exercise(1,"Push Up", 1,"You need lay on the ground and do push ups","https://i.imgur.com/0FHYAVT.gif"));
        exerciseRepository.getExerciseList().add(new Exercise(2,"Pull Up", 2,"You need to pull up", "https://i.imgur.com/Y4x4SwM.gif"));
        exerciseRepository.getExerciseList().add(new Exercise(3,"Sit Up", 1,"You need to sit ups", "https://i.imgur.com/k2uVztg.gif"));
        exerciseRepository.getExerciseList().add(new Exercise(4,"Muscle Up", 3,"You need to muscle up","https://i.imgur.com/mzcW5JK.gif"));
        exerciseRepository.getExerciseList().add(new Exercise(5,"Dip", 2,"You need to dip"));
        exerciseRepository.getExerciseList().add(new Exercise(6,"Squad", 1,"You need to squad"));

        List<Exercise> exerciseList = new ArrayList<>();
        Exercise pushUp = exerciseRepository.getExerciseList().get(0);
        Exercise pullUp = exerciseRepository.getExerciseList().get(1);
        Exercise sitUp = exerciseRepository.getExerciseList().get(2);
        Exercise muscleUp = exerciseRepository.getExerciseList().get(3);
        Exercise dip = exerciseRepository.getExerciseList().get(4);
        Exercise squad = exerciseRepository.getExerciseList().get(5);

        pushUp.setReps(10);
        pullUp.setReps(5);
        sitUp.setReps(10);
        muscleUp.setReps(4);
        exerciseList.add(pushUp);
        exerciseList.add(pullUp);
        exerciseList.add(sitUp);
        exerciseList.add(muscleUp);
        trainingRepository.getTrainings().add(new Training(exerciseList,1L,"Full Body Workout",30,1,4));

        trainingRepository.getTrainings().add(new Training(exerciseList,1L,"Basic Beginner",60,1,4));

        //List<Integer> listOfExercise = new ArrayList<>(trainingRepository.getTrainings().get(1).getExerciseList().values());
        System.out.println("List: "+trainingRepository.getTrainings().get(0));
        System.out.println("Reps: "+trainingRepository.getTrainings().get(0).getExerciseList());
        //System.out.println("Exercises: "+trainingRepository.getTrainings().get(0).getExerciseList().values());
        //System.out.println("lista: "+listOfExercise);

    }
}
