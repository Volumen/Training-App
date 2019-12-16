package pl.pawpam.engineeringproject.gui.training;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import pl.pawpam.engineeringproject.gui.training.StartTrainingGui;
import pl.pawpam.engineeringproject.gui.training.TrainingGui;
import pl.pawpam.engineeringproject.training.Exercise.Exercise;

public class TrainingThread extends Thread{
    private final UI ui;
    //private final TrainingGui view;
    private final StartTrainingGui view;
    //Button okButton;

    private int count = 0;
    int exercise;
    private int countLimit = 5;


    public TrainingThread(UI ui, StartTrainingGui view, int exercise) {
        this.ui = ui;
        this.view = view;
        this.exercise = exercise;


    }
    @Override
    public void run() {
        try {

                while (count < countLimit) {
                    Thread.sleep(1000);
                    ui.access(() -> {
                        count++;
                        view.counterLabel.setText(String.valueOf(count));
                        System.out.println(count);
                    });
                }

                ui.access(() -> {
                        //view.counterLabel.remove();
//                        Exercise tempExercise = new Exercise();
//                                tempExercise = view.newTraining.get().getExerciseList().get(exercise);

                        view.counterLabel.setText("Exercise: " + view.newTraining.get().getExerciseList().get(exercise).getExerciseName() + " Reps: " + view.newTraining.get().getExerciseList().get(exercise).getReps() );
                        view.image.setSrc(view.newTraining.get().getExerciseList().get(exercise).getImgPath());
                        view.image.setAlt(view.newTraining.get().getExerciseList().get(exercise).getExerciseName());
                        view.image.setVisible(true);
                        view.image.setHeight("300px");
                        view.exerciseDescription.setSummaryText("Exercise info:");
                        view.exerciseDescription.setContent(new Span("Stand inside a dip bar and use your arms and shoulders to lift you off the ground. \n" +
                                "  Bend your elbows back using your triceps muscles to move you up and down."));
                        view.exerciseDescription.setEnabled(false);
                        view.exerciseDescription.setOpened(true);
                        count =0;
                });

        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
