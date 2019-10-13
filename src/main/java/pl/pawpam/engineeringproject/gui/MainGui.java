package pl.pawpam.engineeringproject.gui;

import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;


@Route("")
public class MainGui extends VerticalLayout {

    public MainGui() {

        MenuBar barmenu = new MenuBar();
        MenuItem mainPage = barmenu.addItem("Main Page");
        MenuItem login = barmenu.addItem("Login");
        MenuItem register = barmenu.addItem("Register");

        mainPage.addClickListener(event -> {
            mainPage.getUI().ifPresent(ui -> ui.navigate(""));
        });
        register.addClickListener(event -> {
            register.getUI().ifPresent(ui -> ui.navigate("register"));
        });
        login.addClickListener(event -> {
            login.getUI().ifPresent(ui -> ui.navigate("login"));
        });



        add(barmenu);

    }
}
