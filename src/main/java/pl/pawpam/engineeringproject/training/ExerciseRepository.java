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

    }
    public List<Exercise> getExerciseList(){return exerciseList;}
}
