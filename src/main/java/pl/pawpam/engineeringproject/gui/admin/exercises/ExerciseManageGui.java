package pl.pawpam.engineeringproject.gui.admin.exercises;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.pawpam.engineeringproject.gui.menu.Menu;
import pl.pawpam.engineeringproject.training.Exercise;
import pl.pawpam.engineeringproject.training.ExerciseService;
import pl.pawpam.engineeringproject.user.UserServiceImpl;



public class ExerciseManageGui extends VerticalLayout {

    private Label exerciseLabel;
    private ExerciseService exerciseService;

    @Autowired
    public ExerciseManageGui(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
        exerciseLabel = new Label("Halo cwiczenia");

        Image image = new Image();
        image.setClassName("push-up-image");
        //image.setSrc("https://i.imgur.com/4VqkVaH.png");
        Grid<Exercise> exerciseGrid = new Grid<>();
        exerciseGrid.setItems(exerciseService.getExercises());
        exerciseGrid.setSelectionMode(Grid.SelectionMode.SINGLE);
        exerciseGrid.addItemClickListener(event -> {
//            System.out.println("Clicked Item: "+event.getItem().getId());
            this.getUI().ifPresent(ui -> ui.navigate("admin/exercise/"+event.getItem().getId()));
        });
        exerciseGrid.addColumn(Exercise::getId).setHeader("Id");
        exerciseGrid.addColumn(Exercise::getExerciseName).setHeader("Exercise Name");
        exerciseGrid.addColumn(Exercise::getLevel).setHeader("Level");
        exerciseGrid.addColumn(Exercise::getInfo).setHeader("Info");


        add(exerciseLabel,exerciseGrid);
    }
}
