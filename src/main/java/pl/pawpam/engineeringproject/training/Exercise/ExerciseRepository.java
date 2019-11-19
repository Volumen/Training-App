package pl.pawpam.engineeringproject.training.Exercise;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pawpam.engineeringproject.training.Exercise.Exercise;

@Repository("exerciseRepository")
public interface ExerciseRepository extends JpaRepository<Exercise,Integer> {

//    List<Exercise> exerciseList;
//
//    public ExerciseRepository() {
//        this.exerciseList = new ArrayList<>();
//        Image image = new Image();
//        image.setSrc("static/images/push_up.jpg");
//
//    }
//    public List<Exercise> getExerciseList(){return exerciseList;}
}
