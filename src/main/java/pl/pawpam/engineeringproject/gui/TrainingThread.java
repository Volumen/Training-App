package pl.pawpam.engineeringproject.gui;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import pl.pawpam.engineeringproject.gui.training.StartTrainingGui;
import pl.pawpam.engineeringproject.gui.training.TrainingGui;

public class TrainingThread extends Thread{
    private final UI ui;
    //private final TrainingGui view;
    private final StartTrainingGui view;
    //Button okButton;
    Image image;

    private int count = 0;
    int exercise;
    int counter = 0;
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

                        view.counterLabel.setText("Exercise: " + view.newTraining.get().getExerciseList().get(exercise).getExerciseName() + " Reps: " + view.newTraining.get().getExerciseList().get(exercise).getReps());
                        view.image.setSrc(view.newTraining.get().getExerciseList().get(exercise).getImgPath());
                        view.image.setAlt(view.newTraining.get().getExerciseList().get(exercise).getExerciseName());
                        view.image.setVisible(true);
                        view.image.setHeight("300px");
                        count =0;
                });

        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
