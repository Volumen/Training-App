package pl.pawpam.engineeringproject.gui;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Span;

public class FeederThread extends Thread{
    private final UI ui;
    private final TrainingGui view;

    private int count = 0;
    public FeederThread(UI ui, TrainingGui view) {
        this.ui = ui;
        this.view = view;
    }

    @Override
    public void run() {
        try {
            while (count<10)
            {
                Thread.sleep(1000);
                String message = "This is update " + count++;
                ui.access(()->{
                    view.setSpan(String.valueOf(count));
                });
            }
            ui.access(()->{
                view.add(new Span("Done updating"));
            });
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
