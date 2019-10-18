package pl.pawpam.engineeringproject.gui;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.awt.*;

@Route("Training")
public class TrainingGui extends VerticalLayout {
    private Label labelOne;

    public TrainingGui() {
        labelOne = new Label("Choose training!");

    }
}
