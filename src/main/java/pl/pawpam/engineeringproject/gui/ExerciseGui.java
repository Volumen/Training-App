package pl.pawpam.engineeringproject.gui;

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


@Route("exercise")
public class ExerciseGui extends VerticalLayout {

    private Menu mainMenu;
    private Label exerciseLabel;
    private ExerciseService exerciseService;

    private UserServiceImpl userService;

    @Autowired
    public ExerciseGui(UserServiceImpl userService, ExerciseService exerciseService) {
        this.userService = userService;
        this.exerciseService = exerciseService;
        mainMenu = new Menu(userService);
        exerciseLabel = new Label("Halo cwiczenia");

        Image image = new Image();
        image.setClassName("push-up-image");
        image.setSrc("https://i.imgur.com/4VqkVaH.png");
        Grid<Exercise> grid = new Grid<>(Exercise.class);
        grid.setItems(exerciseService.showExercises());
        grid.addComponentColumn(i->image);

        add(mainMenu,exerciseLabel,grid);
    }

}
