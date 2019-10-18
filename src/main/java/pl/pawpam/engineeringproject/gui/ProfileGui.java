package pl.pawpam.engineeringproject.gui;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.pawpam.engineeringproject.gui.menu.Menu;
import pl.pawpam.engineeringproject.user.User;
import pl.pawpam.engineeringproject.user.UserServiceImpl;
import pl.pawpam.engineeringproject.utilities.UserUtilities;



@Route("profile/info")
public class ProfileGui extends VerticalLayout {
    private Label userNameLabel;
    private Label userLastNameLabel;
    private Label userEmailLabel;
    private Label userActiveLabel;
    private Label roleLabel;
    private UserServiceImpl userService;
    private Menu menu;
    private String role;
    private int roleNr;

    @Autowired
    public ProfileGui(UserServiceImpl userService) {
        this.userService = userService;
        setAlignItems(Alignment.CENTER);
        menu = new Menu(userService);

        String username = UserUtilities.getLoggedUser();
        System.out.println("Username: "+username);
        User user = userService.findUserByEmail(username);//bo to email jest naszą nazwa użytkownika
        System.out.println("User: "+user);
         roleNr = user.getRoles().iterator().next().getId(); //w ten sposob odczytujemy nr roli jaka wróci z bazy danych

        userNameLabel = new Label("Name: "+user.getName());
        userLastNameLabel = new Label("Second Name: "+user.getLastName());
        userEmailLabel = new Label("Email: "+user.getEmail());
        userActiveLabel = new Label("Active: "+user.getActive());
        System.out.println(user.getNrRoli());
        if(roleNr==1){role = "Admin";}else {role = "User";}
        roleLabel = new Label("Role: "+role);
        add(userNameLabel,userLastNameLabel,userEmailLabel,userActiveLabel,roleLabel);
    }
}
