package pl.pawpam.engineeringproject.training.Exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService implements ExerciseServiceInterface {

    private ExerciseRepository exerciseRepository;

    @Autowired
    public ExerciseService(@Qualifier("exerciseRepository") ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public void addExercise() {

    }

    @Override
    public List<Exercise> getExercises() {
        return exerciseRepository.findAll();
    }

}
