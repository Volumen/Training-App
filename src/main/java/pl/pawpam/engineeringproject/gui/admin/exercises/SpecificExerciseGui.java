package pl.pawpam.engineeringproject.gui.admin.exercises;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.OptionalParameter;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.pawpam.engineeringproject.training.Exercise.Exercise;
import pl.pawpam.engineeringproject.training.Exercise.ExerciseService;
import pl.pawpam.engineeringproject.training.Exercise.ExerciseServiceInterface;


import java.util.Optional;


@Route("admin/exercise")
public class SpecificExerciseGui extends VerticalLayout implements HasUrlParameter<Long> {
    private Long id;
    private Label exerciseNameLabel;
    private Label exerciseIdLabel;
    private Label exerciseLevelLabel;
    private Label exerciseInfoLabel;
    private ExerciseServiceInterface exerciseService;

    @Autowired
    public SpecificExerciseGui(ExerciseServiceInterface exerciseService) {
        this.exerciseService = exerciseService;
        this.setAlignItems(Alignment.CENTER);
        exerciseNameLabel = new Label();
        exerciseIdLabel = new Label();
        exerciseLevelLabel = new Label();
        exerciseInfoLabel = new Label();
        add(exerciseNameLabel,exerciseIdLabel,exerciseLevelLabel,exerciseInfoLabel);
    }

    @Override
    public void setParameter(BeforeEvent beforeEvent,@OptionalParameter Long id) {
        this.id = id;
        Optional<Exercise> exerciseOptional = exerciseService.getExercises().stream()
                .filter(exercise -> exercise.getId() == id)
                .findFirst();
        System.out.println(exerciseOptional);
        exerciseOptional.ifPresent(exercise ->
        {
            exerciseNameLabel.setText("Exercise name: " + exercise.getExerciseName());
            exerciseIdLabel.setText("Id: " + exercise.getId());
            exerciseLevelLabel.setText("Level: " + exercise.getLevel());
            exerciseInfoLabel.setText("Info: " + exercise.getInfo());
        });
    }
}
