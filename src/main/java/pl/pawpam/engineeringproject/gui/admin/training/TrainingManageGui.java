package pl.pawpam.engineeringproject.gui.admin.training;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.pawpam.engineeringproject.gui.menu.Menu;
import pl.pawpam.engineeringproject.training.Training;
import pl.pawpam.engineeringproject.training.TrainingService;
import pl.pawpam.engineeringproject.training.TrainingServiceInterface;
import pl.pawpam.engineeringproject.user.User;
import pl.pawpam.engineeringproject.user.UserService;
import pl.pawpam.engineeringproject.user.UserServiceInterface;

@Route("admin/training")
public class TrainingManageGui extends VerticalLayout {

    private TrainingServiceInterface trainingService;
    private UserServiceInterface userService;
    private Menu menu;
    private Label label;

    @Autowired
    public TrainingManageGui(UserServiceInterface userService, TrainingServiceInterface trainingService) {
        this.userService = userService;
        this.trainingService = trainingService;
        menu = new Menu(userService);
        label = new Label("Trainings");

        Grid<Training> grid = new Grid<>(Training.class);
        grid.setItems(trainingService.getTrainings());
        System.out.println(trainingService.getTrainings());

        grid.setSelectionMode(Grid.SelectionMode.SINGLE);
        grid.addItemClickListener(event -> {
//            System.out.println("Clicked Item: "+event.getItem().getId());
            this.getUI().ifPresent(ui -> ui.navigate("admin/training/"+event.getItem().getTrainingId()));
        });
        grid.addColumn(Training::getTrainingId).setHeader("Id");
        grid.addColumn(Training::getTrainingName).setHeader("Name");
        //grid.addColumn(Training::getExerciseList).setHeader("Exercises");
        grid.addColumn(Training::getSets).setHeader("Sets");
        grid.addColumn(Training::getLevel).setHeader("Level");
        grid.addColumn(Training::getBreaksBetweenExercises).setHeader("Breaks");
        grid.setHeightByRows(true);

        add(menu,label,grid);
    }
}
