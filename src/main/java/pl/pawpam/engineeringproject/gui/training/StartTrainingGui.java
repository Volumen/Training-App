package pl.pawpam.engineeringproject.gui.training;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.details.Details;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.pawpam.engineeringproject.training.Exercise.Exercise;
import pl.pawpam.engineeringproject.training.Training;
import pl.pawpam.engineeringproject.training.TrainingService;
import pl.pawpam.engineeringproject.training.TrainingServiceInterface;
import pl.pawpam.engineeringproject.user.User;
import pl.pawpam.engineeringproject.user.UserService;
import pl.pawpam.engineeringproject.user.UserServiceInterface;
import pl.pawpam.engineeringproject.utilities.UserUtilities;

import java.util.Optional;

@Push
@Route("training/start")
public class StartTrainingGui extends VerticalLayout implements HasUrlParameter<Long> {
    private Long id=0L;

    private TrainingServiceInterface trainingService;
    private TrainingThread thread;
    public Optional<Training> newTraining;
    public Button showTrainingButton;
    public Button startButton;
    public Button continueButton;
    public Label trainingNameLabel;
    private Label levelLabel;
    private Label breaksLabel;
    private Label setsLabel;
    public Label fullTimeLabel;
    private Grid<Exercise> trainingGrid;
    private HorizontalLayout horizontalLayout;
    private HorizontalLayout trainingInfoLayout;
    private VerticalLayout trainingLayout;
    public Label counterLabel;
    public Image image;
    private Thread fullTimeThread;
    private UserServiceInterface userService;
    public int fullTime = 0;
    public Details exerciseDescription;

    int exerciseNumber = 0;
    int setNumber = 0;

    @Autowired
    public StartTrainingGui(TrainingServiceInterface trainingService, UserServiceInterface userService) {
        this.trainingService = trainingService;
        this.userService = userService;

    }

    @Override
    public void setParameter(BeforeEvent beforeEvent, Long id) {
        this.id = id;
        setAlignItems(Alignment.CENTER);
        showTrainingButton = new Button("Show training");
        startButton = new Button("Start!");
        image = new Image();

        trainingNameLabel = new Label();
        levelLabel = new Label();
        breaksLabel = new Label();
        setsLabel = new Label();
        fullTimeLabel  = new Label("Full time: 0");
        fullTimeLabel.addClassName("full-time-counter");
        trainingGrid = new Grid<>();
        trainingGrid.setVisible(false);
        horizontalLayout = new HorizontalLayout();
        trainingLayout = new VerticalLayout();
        trainingInfoLayout = new HorizontalLayout();
        continueButton = new Button("OK!");
        counterLabel = new Label();
        continueButton.setVisible(false);

        exerciseDescription = new Details();


        fullTimeThread = new CountingTrainingTimeThread(UI.getCurrent(),this);

        newTraining = trainingService.getTrainings()
                .stream()
                .filter(training -> training.getTrainingId() == id)
                .findFirst();
        String username = UserUtilities.getLoggedUser();
        User user = userService.findUserByEmail(username);

        showTrainingButton.addClickListener(event -> {
            showTrainingButton.setEnabled(false);
            trainingGrid.setVisible(true);


            trainingNameLabel.setText("Name: "+newTraining.get().getTrainingName());
            levelLabel.setText("Level: "+newTraining.get().getLevel());
            breaksLabel.setText("Breaks between exercises: "+newTraining.get().getBreaksBetweenExercises()+"sec");
            setsLabel.setText("Sets: "+newTraining.get().getSets());

            trainingGrid.setItems(newTraining.get().getExerciseList());
            trainingGrid.addColumn(Exercise::getExerciseName).setHeader("Exercise");
            trainingGrid.addColumn(Exercise::getReps).setHeader("Reps");
            trainingGrid.setHeightByRows(true);

        });

        startButton.addClickListener(event -> {
            horizontalLayout.removeAll();
            continueButton.setVisible(true);
            startButton.setVisible(false);
            setAlignItems(Alignment.CENTER);


            //trainingLayout.add(counterLabel);
            //add(counterLabel);

            thread = new TrainingThread(UI.getCurrent(),this,0);
            thread.start();
            fullTimeThread.start();




        });
        continueButton.addClickListener(event -> {
            if(setNumber==newTraining.get().getSets()-1 && exerciseNumber == newTraining.get().getExerciseList().size() - 1)
            {
                Training finalTraining = new Training();
                convertTraining(finalTraining, newTraining.get());
                fullTimeThread.interrupt();
                thread.interrupt();
                System.out.println("koniec treningu");
                counterLabel.setText("END!");

                finalTraining.setUserId(user.getId());
                finalTraining.setFullTimeOfTraining(fullTime);
                trainingService.saveTraining(finalTraining);
                 //to read data in email class

                trainingService.sendMail();
            }
            else {
                if (exerciseNumber == newTraining.get().getExerciseList().size() - 1) {
                    exerciseNumber = 0;
                    setNumber++;
                } else {
                    exerciseNumber++;
                }


                thread = new TrainingThread(UI.getCurrent(), this, exerciseNumber);
                thread.start();

            }
        });
        trainingInfoLayout.add(trainingNameLabel,levelLabel,breaksLabel,setsLabel,fullTimeLabel);
        horizontalLayout.setWidth("300px");
        horizontalLayout.add(trainingGrid);
        add(showTrainingButton,trainingInfoLayout,horizontalLayout,startButton,counterLabel,image,exerciseDescription,continueButton);
    }
    private void convertTraining(Training trainingOne, Training trainingTwo)
    {
        trainingOne.setLevel(trainingTwo.getLevel());
        trainingOne.setBreaksBetweenExercises(trainingTwo.getBreaksBetweenExercises());
        trainingOne.setExerciseList(trainingTwo.getExerciseList());
        trainingOne.setTrainingName(trainingTwo.getTrainingName());
        trainingOne.setSets(trainingTwo.getSets());
    }
}
