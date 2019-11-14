package pl.pawpam.engineeringproject.gui;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;

public class Components extends UI {
    public Button backButton;

    public Components() {
    }
    public Button addBackButton(String path)
    {
        backButton = new Button("Back");
        backButton.addClickListener(event -> {
            this.getUI().ifPresent(ui -> ui.navigate("admin"));
        });
        return backButton;
    }
}
