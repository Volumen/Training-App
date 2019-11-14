package pl.pawpam.engineeringproject.gui;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.NavigationEvent;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import pl.pawpam.engineeringproject.gui.menu.Menu;
import pl.pawpam.engineeringproject.user.UserServiceImpl;

import java.security.AccessController;


@Route("")
public class MainGui extends VerticalLayout {
    private Menu mainMenu;
        private MenuBar menuBar;
        UserServiceImpl userService;
        private Button button;

        @Autowired
    public MainGui(UserServiceImpl userService) {
        this.userService = userService;
        mainMenu = new Menu(userService);
        Label l1 = new Label("halo");
        button = new Button("Hallo!");
        button.setClassName("buttonOne");


        add(mainMenu,l1,button);

    }

//    private void Menu() {
//        barmenu = new MenuBar();
//
//        MenuItem mainPage = barmenu.addItem("Main Page");
//        MenuItem login = barmenu.addItem("Login");
//        MenuItem register = barmenu.addItem("Register");
//
//        mainPage.addClickListener(event -> {
//            mainPage.getUI().ifPresent(ui -> ui.navigate(""));
//        });
//        register.addClickListener(event -> {
//            register.getUI().ifPresent(ui -> ui.navigate("register"));
//        });
//        login.addClickListener(event -> {
//            login.getUI().ifPresent(ui -> ui.navigate("login"));
//        });
//
//
//        add(barmenu);
//    }
//    public MenuBar getBarmenu() {
//        return barmenu;
//    }
}
