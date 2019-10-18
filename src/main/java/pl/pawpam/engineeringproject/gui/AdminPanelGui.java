package pl.pawpam.engineeringproject.gui;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import pl.pawpam.engineeringproject.admin.AdminServiceImpl;
import pl.pawpam.engineeringproject.gui.menu.Menu;
import pl.pawpam.engineeringproject.user.User;
import pl.pawpam.engineeringproject.user.UserServiceImpl;

//@Secured(value = "ROLE_ADMIN")
@Route("admin")
public class AdminPanelGui extends VerticalLayout {
    private UserServiceImpl userService;
    private Menu menu;
    private Label adminLabel;
    private AdminServiceImpl adminService;

    @Autowired
    public AdminPanelGui(UserServiceImpl userService,AdminServiceImpl adminService) {
        this.userService = userService;
        this.adminService = adminService;
        menu = new Menu(userService);
        adminLabel = new Label("Administration");

        Grid<User> grid = new Grid<>(User.class);
        grid.setItems(adminService.getUsers());

        add(menu,adminLabel,grid);
    }
}
