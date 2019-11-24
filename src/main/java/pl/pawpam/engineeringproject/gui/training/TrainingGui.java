package pl.pawpam.engineeringproject.gui.training;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.pawpam.engineeringproject.gui.menu.Menu;
import pl.pawpam.engineeringproject.training.TrainingService;
import pl.pawpam.engineeringproject.user.UserService;


@Route("training")
public class TrainingGui extends VerticalLayout {
    private UserService userService;
    private TrainingService trainingService;
    private Menu menu;
    private Label counterLabel;
    private Button fullBodyWorkoutButton;
    private Button pushAndPullButton;
    private Button beginnerAbsButton;
    private HorizontalLayout horizontalLayout;
    private Span span;

    @Autowired
    public TrainingGui(UserService userService, TrainingService trainingService) {
        this.userService = userService;
        this.trainingService = trainingService;
        menu = new Menu(userService);

        counterLabel = new Label("Choose training!");
        fullBodyWorkoutButton = new Button("Full Body Workout");
        pushAndPullButton = new Button("Push and Pull");
        beginnerAbsButton = new Button("Beginner ABS");
        horizontalLayout = new HorizontalLayout();
        fullBodyWorkoutButton.addClickListener(event->{
            this.getUI().ifPresent(ui -> ui.navigate(StartTrainingGui.class, trainingService.getTrainings().get(0).getTrainingId()));
        });
        pushAndPullButton.addClickListener(event -> {
            this.getUI().ifPresent(ui -> ui.navigate(StartTrainingGui.class, trainingService.getTrainings().get(1).getTrainingId()));

        });
        horizontalLayout.add(fullBodyWorkoutButton,pushAndPullButton,beginnerAbsButton);
        add(menu,counterLabel,horizontalLayout);

    }
}
