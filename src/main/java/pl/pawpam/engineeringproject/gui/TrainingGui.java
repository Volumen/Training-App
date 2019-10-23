package pl.pawpam.engineeringproject.gui;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.router.Route;

import java.util.Timer;
import java.util.TimerTask;

@Push
@Route("training")
public class TrainingGui extends VerticalLayout {
    private Label counterLabel;
    private Button startButton;
    private FeederThread thread;
    int i =0;

    public TrainingGui() {
        counterLabel = new Label("Choose training!");
        startButton = new Button("Start");
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        startButton.addClickListener(e->{
            thread = new FeederThread(UI.getCurrent(),this);
            thread.start();
        });


        add(counterLabel,startButton);

    }

//    @Override
//    protected void onAttach(AttachEvent attachEvent) {
//
//    }

    public void setLabel(String s) {
        counterLabel.setText(s);
    }
}
