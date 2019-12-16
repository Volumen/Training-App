package pl.pawpam.engineeringproject.gui.admin.users;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import pl.pawpam.engineeringproject.admin.AdminServiceInterface;
import pl.pawpam.engineeringproject.admin.AdminServiceImpl;
import pl.pawpam.engineeringproject.user.User;

public class UsersManageGui extends VerticalLayout{

    private AdminServiceInterface adminService;
    private Label label;

    @Autowired
    public UsersManageGui(AdminServiceInterface adminService) {
        this.adminService = adminService;

        label = new Label("Users");

        Grid<User> userGrid = new Grid<>();
        userGrid.setItems(adminService.getUsers());

        userGrid.setSelectionMode(Grid.SelectionMode.SINGLE);
        userGrid.addItemClickListener(event -> {
//            System.out.println("Clicked Item: "+event.getItem().getId());
            this.getUI().ifPresent(ui -> ui.navigate("admin/user/"+event.getItem().getId()));
        });
        userGrid.addColumn(User::getId).setHeader("Id");
        userGrid.addColumn(User::getName).setHeader("Name");
        userGrid.addColumn(User::getLastName).setHeader("Last Name");
        userGrid.addColumn(User::getEmail).setHeader("Email");
        userGrid.setHeightByRows(true);
        

        add(label,userGrid);

    }

}
