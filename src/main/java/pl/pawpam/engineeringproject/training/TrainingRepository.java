package pl.pawpam.engineeringproject.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TrainingRepository {
    List<Training> trainingList;

    ExerciseRepository exerciseRepository;

    @Autowired
    public TrainingRepository(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
        trainingList = new ArrayList<>();
        trainingList.add(new Training(exerciseRepository.getExerciseList(),5,30,1));
    }
    public List<Training> getTrainings(){
        return trainingList;
    }
}
