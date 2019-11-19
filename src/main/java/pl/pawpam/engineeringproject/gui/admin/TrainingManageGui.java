package pl.pawpam.engineeringproject.gui.admin;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.pawpam.engineeringproject.gui.menu.Menu;
import pl.pawpam.engineeringproject.training.Training;
import pl.pawpam.engineeringproject.training.TrainingService;
import pl.pawpam.engineeringproject.user.UserService;

@Route("admin/training")
public class TrainingManageGui extends VerticalLayout {

    private TrainingService trainingService;
    private UserService userService;
    private Menu menu;
    private Label label;

    @Autowired
    public TrainingManageGui(UserService userService, TrainingService trainingService) {
        this.userService = userService;
        this.trainingService = trainingService;
        menu = new Menu(userService);
        label = new Label("Trainings");

        Grid<Training> grid = new Grid<>(Training.class);
        grid.setItems(trainingService.getTrainings());
        System.out.println(trainingService.getTrainings());

        add(menu,label,grid);
    }
}
