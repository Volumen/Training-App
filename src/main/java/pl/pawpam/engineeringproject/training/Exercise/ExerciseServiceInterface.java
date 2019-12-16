package pl.pawpam.engineeringproject.training.Exercise;

import pl.pawpam.engineeringproject.training.Exercise.Exercise;

import java.util.List;

public interface ExerciseServiceInterface {
     void addExercise(Exercise exercise);
     List<Exercise> getExercises();
}
