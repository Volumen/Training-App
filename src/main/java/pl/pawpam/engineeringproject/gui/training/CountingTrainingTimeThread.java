package pl.pawpam.engineeringproject.gui.training;

import com.vaadin.flow.component.UI;

public class CountingTrainingTimeThread extends Thread {
    private final UI ui;
    //private final TrainingGui view;
    private final StartTrainingGui view;
    public boolean endOfTraining=false;
    int count=0;
    public CountingTrainingTimeThread(UI ui, StartTrainingGui view) {
    this.ui = ui;
    this.view = view;
    }
    @Override
    public void interrupt() {
        view.fullTime = count;
        super.interrupt();
    }

    @Override
    public void run() {
        try {
            while (!endOfTraining)
            {
                Thread.sleep(1000);
                ui.access(() -> {
                    count++;
                    view.fullTimeLabel.setText("Full time: "+count);
                });

            }

        }
        catch (InterruptedException e)
        {
            System.out.println();
        }
    }
}
