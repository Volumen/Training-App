package pl.pawpam.engineeringproject.gui.menu;

import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import pl.pawpam.engineeringproject.user.User;
import pl.pawpam.engineeringproject.user.UserServiceImpl;
import pl.pawpam.engineeringproject.utilities.UserUtilities;

@CssImport("styles/custom-styles.css")
@Route("menu")
public class Menu extends VerticalLayout {
    private MenuBar barmenu;
    private MenuBar barmenuTwo;
    private HorizontalLayout horizontalLayout;
    private Div div;

    private UserServiceImpl userService;
    int roleNr;

    @Autowired
    public Menu(UserServiceImpl userService) {
        this.userService = userService;
        horizontalLayout = new HorizontalLayout();
        horizontalLayout.setClassName("menu-horizontal");
        barmenu = new MenuBar();
        barmenuTwo = new MenuBar();
        div = new Div();
        div.setClassName("mainDiv");
        //UI.getCurrent().getElement().setAttribute("theme", Lumo.DARK);

        barmenu.setClassName("bar-menu-left");
        barmenuTwo.setClassName("bar-menu-right");
        MenuItem mainPage = barmenu.addItem("Main Page");
        MenuItem login = barmenu.addItem("Login");
        MenuItem register = barmenu.addItem("Register");
        MenuItem adminPanel = barmenu.addItem("AdminPanel");
        MenuItem trainingButton = barmenu.addItem("Training!");
        MenuItem logoutButton = barmenuTwo.addItem("Logout");
        MenuItem profileInfoButton = barmenuTwo.addItem("Profile");

        horizontalLayout.add(barmenu,barmenuTwo);
        div.add(horizontalLayout);

     if(UserUtilities.getLoggedUser() == null)
     {
         System.out.println("Jest puste!");
         roleNr=0;
     }
     else {
         try {
             String username = UserUtilities.getLoggedUser();
             User user = userService.findUserByEmail(username);//bo to email jest naszą nazwa użytkownika
             System.out.println("User: "+user);
             roleNr = user.getRoles().iterator().next().getId(); //w ten sposob odczytujemy nr roli jaka wróci z bazy danych
         }
         catch (Exception e) {
             System.out.println("Message: "+e.getMessage());

         }
     }

        if(roleNr==1)
        {
            login.setEnabled(false);
            login.setVisible(false);
            register.setEnabled(false);
            register.setVisible(false);
        }
        else if(roleNr == 2)
        {
            login.setEnabled(false);
            login.setVisible(false);
            register.setEnabled(false);
            register.setVisible(false);
            adminPanel.setEnabled(false);
            adminPanel.setVisible(false);
        }
        else {
            adminPanel.setEnabled(false);
            adminPanel.setVisible(false);
            logoutButton.setVisible(false);
            logoutButton.setEnabled(false);
            profileInfoButton.setVisible(false);
            profileInfoButton.setEnabled(false);
            trainingButton.setVisible(false);
            trainingButton.setEnabled(false);
        }

        mainPage.addClickListener(event -> {
            mainPage.getUI().ifPresent(ui -> ui.navigate(""));
        });
        register.addClickListener(event -> {
            register.getUI().ifPresent(ui -> ui.navigate("register"));
        });
        login.addClickListener(event -> {
            login.getUI().ifPresent(ui -> ui.navigate("login"));
        });
        adminPanel.addClickListener(event -> {
            adminPanel.getUI().ifPresent(ui -> ui.navigate("admin"));
        });
        logoutButton.addClickListener(event -> {
            SecurityContextHolder.clearContext();
           // getUI().get().getSession().close();
           // getUI().ifPresent(ui -> ui.navigate(""));
            getUI().get().getPage().executeJs("window.location.href=''");

            // Close the session
            getUI().get().getSession().close();
        });
        profileInfoButton.addClickListener(event -> {
            profileInfoButton.getUI().ifPresent(ui -> ui.navigate("profile/info"));
        });
        trainingButton.addClickListener(event -> {
            trainingButton.getUI().ifPresent(ui -> ui.navigate("training"));
        });



        add(div);
    }

}
