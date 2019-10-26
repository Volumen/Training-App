package pl.pawpam.engineeringproject.training;

import com.vaadin.flow.component.html.Image;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ExerciseRepository {

    List<Exercise> exerciseList;

    public ExerciseRepository() {
        this.exerciseList = new ArrayList<>();
        Image image = new Image();
        image.setSrc("static/images/push_up.jpg");
        Exercise exerciseOne = new Exercise(1,"Push Ups", 1,"You need lay on the ground and do push ups",image);
        Exercise exerciseTwo = new Exercise(2,"Pull Ups", 1,"You need to pull up",image);
        Exercise exerciseThree = new Exercise(3,"Sit Ups", 1,"You need to sit ups",image);
        Exercise exerciseFour = new Exercise(4,"Muscle Up", 1,"You need to muscle up",image);
        exerciseList.add(exerciseOne);
        exerciseList.add(exerciseTwo);
        exerciseList.add(exerciseThree);
        exerciseList.add(exerciseFour);
    }
    public List<Exercise> getExerciseList(){return exerciseList;}
}
