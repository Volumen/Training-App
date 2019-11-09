package pl.pawpam.engineeringproject.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TrainingRepository {
    List<Training> trainingList;

    ExerciseRepository exerciseRepository;

    @Autowired
    public TrainingRepository(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
        trainingList = new ArrayList<>();


    }
    public List<Training> getTrainings(){
        return trainingList;
    }
}
