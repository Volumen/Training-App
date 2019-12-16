package pl.pawpam.engineeringproject.gui.admin.exercises;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import pl.pawpam.engineeringproject.training.Exercise.Exercise;
import pl.pawpam.engineeringproject.training.Exercise.ExerciseService;
import pl.pawpam.engineeringproject.training.Exercise.ExerciseServiceInterface;


public class ExerciseManageGui extends VerticalLayout {

    private Label exerciseLabel;
    private ExerciseServiceInterface exerciseService;

    @Autowired
    public ExerciseManageGui(ExerciseServiceInterface exerciseService) {
        this.exerciseService = exerciseService;
        exerciseLabel = new Label("Exercises");

        Image image = new Image();
        image.setClassName("push-up-image");
        Grid<Exercise> exerciseGrid = new Grid<>();
        exerciseGrid.setItems(exerciseService.getExercises());
        exerciseGrid.setSelectionMode(Grid.SelectionMode.SINGLE);
        exerciseGrid.addItemClickListener(event -> {
            this.getUI().ifPresent(ui -> ui.navigate("admin/exercise/"+event.getItem().getId()));
        });
        exerciseGrid.addColumn(Exercise::getId).setHeader("Id");
        exerciseGrid.addColumn(Exercise::getExerciseName).setHeader("Exercise Name");
        exerciseGrid.addColumn(Exercise::getLevel).setHeader("Level");
        exerciseGrid.addColumn(Exercise::getInfo).setHeader("Info");
        exerciseGrid.setHeightByRows(true);


        add(exerciseLabel,exerciseGrid);
    }
}
