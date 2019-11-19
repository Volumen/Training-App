package pl.pawpam.engineeringproject.gui.training;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.pawpam.engineeringproject.gui.TrainingThread;
import pl.pawpam.engineeringproject.training.Exercise.Exercise;
import pl.pawpam.engineeringproject.training.Training;
import pl.pawpam.engineeringproject.training.TrainingService;

import java.util.Optional;

@Push
@Route("training/start")
public class StartTrainingGui extends VerticalLayout implements HasUrlParameter<Long> {
    private Long id=0L;

    private TrainingService trainingService;
    private TrainingThread thread;
    public Optional<Training> newTraining;
    public Button showTrainingButton;
    public Button startButton;
    public Button continueButton;
    public Label trainingNameLabel;
    private Label levelLabel;
    private Label breaksLabel;
    private Grid<Exercise> trainingGrid;
    private HorizontalLayout horizontalLayout;
    private HorizontalLayout trainingInfoLayout;
    private VerticalLayout trainingLayout;
    public Label counterLabel;
    public Image image;

    int exerciseNumber = 0;
    int setNumber = 0;

    @Autowired
    public StartTrainingGui(TrainingService trainingService) {
        this.trainingService = trainingService;

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
        trainingGrid = new Grid<>();
        trainingGrid.setVisible(false);
        horizontalLayout = new HorizontalLayout();
        trainingLayout = new VerticalLayout();
        trainingInfoLayout = new HorizontalLayout();
        continueButton = new Button("OK!");
        continueButton.setVisible(false);

        newTraining = trainingService.getTrainings()
                .stream()
                .filter(training -> training.getTrainingId() == id)
                .findFirst();


        showTrainingButton.addClickListener(event -> {
            showTrainingButton.setEnabled(false);
            trainingGrid.setVisible(true);


            trainingNameLabel.setText("Name: "+newTraining.get().getTrainingName());
            levelLabel.setText("Level: "+newTraining.get().getLevel());
            breaksLabel.setText("Breaks between exercises: "+newTraining.get().getBreaksBetweenExercises()+"sec");

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
            counterLabel = new Label("ss");

            trainingLayout.add(counterLabel);
            add(counterLabel);

            thread = new TrainingThread(UI.getCurrent(),this,0);
            thread.start();

        });
        continueButton.addClickListener(event -> {
            if(setNumber==newTraining.get().getSets()-1 && exerciseNumber == newTraining.get().getExerciseList().size() - 1)
            {

                thread.interrupt();
                System.out.println("koniec treningu");
                trainingService.sendMail();
                counterLabel.setText("Koniec!");
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
        trainingInfoLayout.add(trainingNameLabel,levelLabel,breaksLabel,image);
        horizontalLayout.setWidth("300px");
        horizontalLayout.add(trainingGrid);
        add(showTrainingButton,trainingInfoLayout,horizontalLayout,startButton,continueButton);
    }
}
