package pl.pawpam.engineeringproject.admin;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.router.RouterLayout;

public class Components implements RouterLayout {
    Button backButton;

    public Button getBackButton(String path)
    {
        backButton = new Button("Back");
        backButton.addClickListener(buttonClickEvent -> backButton.getUI().ifPresent(ui -> ui.navigate(path)));
        return backButton;
    }
    @Override
    public Element getElement() {

        return null;
    }
}
