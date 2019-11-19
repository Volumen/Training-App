package pl.pawpam.engineeringproject.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pawpam.engineeringproject.training.Exercise.ExerciseRepository;

import java.util.ArrayList;
import java.util.List;

@Repository("trainingRepository")
public interface TrainingRepository extends JpaRepository<Training, Integer> {
//    List<Training> trainingList;

//
//    ExerciseRepository exerciseRepository;
//
//    @Autowired
//    public TrainingRepository(ExerciseRepository exerciseRepository) {
//        this.exerciseRepository = exerciseRepository;
//        trainingList = new ArrayList<>();
//
//
//    }
//    public List<Training> getTrainings(){
//        return trainingList;
//    }
}
