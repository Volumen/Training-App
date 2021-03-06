package pl.pawpam.engineeringproject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.pawpam.engineeringproject.training.Exercise.Exercise;
import pl.pawpam.engineeringproject.training.Exercise.ExerciseRepository;
import pl.pawpam.engineeringproject.training.Training;
import pl.pawpam.engineeringproject.training.TrainingRepository;
import pl.pawpam.engineeringproject.user.User;
import pl.pawpam.engineeringproject.user.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class DataLoader implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(DataLoader.class);
    private ExerciseRepository exerciseRepository;
    private TrainingRepository trainingRepository;
    private UserRepository userRepository;


    @Autowired
    public DataLoader(@Qualifier("exerciseRepository") ExerciseRepository exerciseRepository,@Qualifier("trainingRepository") TrainingRepository trainingRepository, @Qualifier("userRepository") UserRepository userRepository) {
        this.exerciseRepository = exerciseRepository;
        this.trainingRepository = trainingRepository;
        this.userRepository = userRepository;

    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Loading Exercises and Trainings from DataLoader...");
//        exerciseRepository.getExerciseList().add(new Exercise(1,"Push Up", 1,"You need lay on the ground and do push ups","https://i.imgur.com/0FHYAVT.gif"));
//        exerciseRepository.getExerciseList().add(new Exercise(2,"Pull Up", 2,"You need to pull up", "https://i.imgur.com/Y4x4SwM.gif"));
//        exerciseRepository.getExerciseList().add(new Exercise(3,"Sit Up", 1,"You need to sit ups", "https://i.imgur.com/k2uVztg.gif"));
//        exerciseRepository.getExerciseList().add(new Exercise(4,"Muscle Up", 3,"You need to muscle up","https://i.imgur.com/mzcW5JK.gif"));
//        exerciseRepository.getExerciseList().add(new Exercise(5,"Dip", 2,"You need to dip"));
//        exerciseRepository.getExerciseList().add(new Exercise(6,"Squad", 1,"You need to squad"));
//
//        List<Exercise> exerciseList = new ArrayList<>();
//        Exercise pushUp = exerciseRepository.getExerciseList().get(0);
//        Exercise pullUp = exerciseRepository.getExerciseList().get(1);
//        Exercise sitUp = exerciseRepository.getExerciseList().get(2);
//        Exercise muscleUp = exerciseRepository.getExerciseList().get(3);
//        Exercise dip = exerciseRepository.getExerciseList().get(4);
//        Exercise squad = exerciseRepository.getExerciseList().get(5);
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pl.pawpam.engineeringproject");
//
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//       // trainingRepository.save(new Training(exerciseRepository.findAll(),"Full Body Workout",5,1,4));
//
//        entityManager
//                .createNativeQuery("ALTER TABLE training AUTO_INCREMENT = 2")
//                .executeUpdate();
//        List<Exercise> exercises = new ArrayList<>();
//        exercises.add(exerciseRepository.findAll().get(0));
//        exercises.add(exerciseRepository.findAll().get(3));
//        trainingRepository.save(new Training(exercises,"Abs Two",10,2,4));
       // System.out.println(trainingRepository.findAll().get(0).getExerciseList());
//        System.out.println(trainingRepository.findAll());
//        System.out.println("Pierwszy: "+trainingRepository.findAll().get(0).getExerciseList());
//        System.out.println("Drugi: "+trainingRepository.findAll().get(1).getExerciseList());
       // System.out.println(exerciseRepository.findAll());
//        exerciseRepository.save(new Exercise("Push Ups", 1,"exercise.push-up.info","https://i.imgur.com/0FHYAVT.gif"));
//        exerciseRepository.save(new Exercise("Pull Ups", 2,"exercise.pull-up.info","https://i.imgur.com/Y4x4SwM.gif"));
//
//        exerciseRepository.save(new Exercise("Crunches", 1,"exercise.crunches.info","https://i.imgur.com/k2uVztg.gif"));
//
//        exerciseRepository.save(new Exercise("Dips", 2,"exercise.dip.info","https://i.imgur.com/NNZc7KY.gifv"));
//        exerciseRepository.save(new Exercise("Muscle Ups", 3,"exercise.muscle-up.info","https://i.imgur.com/mzcW5JK.gif"));
//        exerciseRepository.save(new Exercise("Chin Ups", 2,"exercise.chin-up.info","https://i.imgur.com/bTblGem.gifv"));
//        exerciseRepository.save(new Exercise("Squads", 1,"exercise.squad.info","https://i.imgur.com/IojovAe.gifv"));
//        exerciseRepository.save(new Exercise("plank", 2,"exercise.squad.info","https://i.imgur.com/IojovAe.gifv"));


        List<Exercise> exerciseList = new ArrayList<>();
        Exercise pushUps = exerciseRepository.findAll().get(0);
        Exercise pullUps = exerciseRepository.findAll().get(1);
        Exercise crunches = exerciseRepository.findAll().get(2);
        Exercise dips = exerciseRepository.findAll().get(3);
        Exercise muscleUps = exerciseRepository.findAll().get(4);
        Exercise chinUps = exerciseRepository.findAll().get(5);
        Exercise squad = exerciseRepository.findAll().get(6);

        pushUps.setReps(15);
        pullUps.setReps(5);
        crunches.setReps(10);
        dips.setReps(10);
        muscleUps.setReps(4);
        chinUps.setReps(5);
        squad.setReps(10);
        exerciseList.add(pushUps);
        exerciseList.add(pullUps);
        exerciseList.add(muscleUps);
//        exerciseList.add(dips);
//        exerciseList.add(muscleUps);
//        exerciseList.add(chinUps);
        exerciseList.add(dips);
        //trainingRepository.save(new Training(exerciseList,"Push and Pull",20,2,4));
//
//       trainingRepository.getTrainings().add(new Training(exerciseList,1L,"Basic Beginner",60,1,4));
//
//        //List<Integer> listOfExercise = new ArrayList<>(trainingRepository.getTrainings().get(1).getExerciseList().values());
//        System.out.println("List: "+trainingRepository.getTrainings().get(0));
//        System.out.println("Reps: "+trainingRepository.getTrainings().get(0).getExerciseList());
        //System.out.println("Exercises: "+trainingRepository.getTrainings().get(0).getExerciseList().values());
        //System.out.println("lista: "+listOfExercise);
       // System.out.println(trainingRepository.findAll());

//        User user = userRepository.findByEmail("michal.nowak@gmail.com");
//        userRepository.updateUserId(5,"anna.nowak@gmail.com");


    }
}
