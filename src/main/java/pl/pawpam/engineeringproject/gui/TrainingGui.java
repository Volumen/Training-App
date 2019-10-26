package pl.pawpam.engineeringproject.gui;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.DetachEvent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.pawpam.engineeringproject.gui.menu.Menu;
import pl.pawpam.engineeringproject.training.Training;
import pl.pawpam.engineeringproject.training.TrainingService;
import pl.pawpam.engineeringproject.user.UserServiceImpl;

import java.util.Timer;
import java.util.TimerTask;

@Push
@Route("training")
public class TrainingGui extends VerticalLayout {
    private UserServiceImpl userService;
    private TrainingService trainingService;
    private Menu menu;
    private Label counterLabel;
    private Button startButton;
    private Span span;
    private FeederThread thread;
    int i =0;

    @Autowired
    public TrainingGui(UserServiceImpl userService, TrainingService trainingService) {
        this.userService = userService;
        this.trainingService = trainingService;
        menu = new Menu(userService);
        span = new Span("Halo");

        counterLabel = new Label("Choose training!");
        startButton = new Button("Start");
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        startButton.addClickListener(e->{
            thread = new FeederThread(UI.getCurrent(),this);
            thread.start();
        });
        /////
//        Training training = trainingService.getTrainings().get(0);
//        String exerciseName = training.getExerciseList().get(0).getExerciseName();
//        int reps = training.getReps();
//        Label label = new Label("1: "+exerciseName+"reps: "+reps);

        //////
        add(menu,counterLabel,startButton,span);

    }

    public Label getCounterLabel() {
        return counterLabel;
    }

    public void setSpan(String s) {
        span.setText(s);
    }

    @Override
    protected void onAttach(AttachEvent attachEvent) {

    }

    @Override
    protected void onDetach(DetachEvent detachEvent) {
        thread.interrupt();
        thread = null;
    }
}
