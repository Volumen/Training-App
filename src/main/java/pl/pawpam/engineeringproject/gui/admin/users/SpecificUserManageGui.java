package pl.pawpam.engineeringproject.gui.admin.users;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.pawpam.engineeringproject.admin.AdminServiceInterface;
import pl.pawpam.engineeringproject.admin.AdminServiceImpl;
import pl.pawpam.engineeringproject.user.User;
import pl.pawpam.engineeringproject.user.UserService;
import pl.pawpam.engineeringproject.user.UserServiceInterface;

import java.util.Optional;

@Route(value = "admin/user")
public class SpecificUserManageGui extends VerticalLayout implements HasUrlParameter<Long> {
    private Long id;
    private UserServiceInterface userService;
    private AdminServiceInterface adminService;
    private Label nameLabel;
    private Label lastNameLabel;
    private Label emailLabel;
    private Checkbox activeCheckbox;
    private ComboBox<String> roleComboBox;
    private Button saveButton;
    private Button deleteUserButton;
    private int roleNumber;
    private int active;
    private HorizontalLayout buttonsLayout;

    @Autowired
    public SpecificUserManageGui(UserServiceInterface userService, AdminServiceInterface adminService) {
    this.userService = userService;
    this.adminService = adminService;
    nameLabel = new Label();
    lastNameLabel = new Label();
    emailLabel = new Label();
    activeCheckbox = new Checkbox();
    roleComboBox = new ComboBox<>();
    saveButton = new Button("Save");
    deleteUserButton = new Button("Delete User");
    deleteUserButton.setClassName("delete-button");
    buttonsLayout = new HorizontalLayout();
    setAlignItems(Alignment.CENTER);

    buttonsLayout.add(saveButton,deleteUserButton);

    add(nameLabel,lastNameLabel,emailLabel,activeCheckbox,roleComboBox,buttonsLayout);

    }

    @Override
    public void setParameter(BeforeEvent beforeEvent, Long id) {
        this.id = id;

        Optional<User> userOptional = adminService.getUsers().stream()
                .filter(user -> user.getId() == id)
                .findFirst();
//        System.out.println(exerciseOptional);


        userOptional.ifPresent(user ->
        {
            deleteUserButton.addClickListener(event -> {
                adminService.deleteUser((int)userOptional.get().getId());
            });
            nameLabel.setText("Name: "+ user.getName());
            lastNameLabel.setText("Last Name: "+ user.getLastName());
            emailLabel.setText("Email: "+user.getEmail());
            roleComboBox.setLabel("Role");
            roleComboBox.setItems("Trainer","User");
            roleNumber = user.getRoles().iterator().next().getId();
            int idUser = (int) user.getId();
            System.out.println("moja rola: "+roleNumber);

            if(user.getActive()==1)
            {
                activeCheckbox.setValue(true);
                activeCheckbox.setLabel("Active");
            }
            else { activeCheckbox.setLabel("Non Active"); }
            if(roleNumber==1)
            {

                roleComboBox.setValue("Trainer");
            }
            else {roleComboBox.setValue("User");}
            saveButton.addClickListener(event -> {
                System.out.println(roleComboBox.getValue());
                if (roleComboBox.getValue().equals("Trainer"))
                {
                    roleNumber = 1;
                }
                else {
                    roleNumber = 2;
                }
                if (activeCheckbox.isEmpty())
                {
                    active = 0;
                }
                else
                {
                    active = 1;
                }
                System.out.println("role number:" +roleNumber);
                System.out.println("active:" +active);
                adminService.updateUser(idUser,roleNumber,active);
                UI.getCurrent().getPage().reload();
            });

        });
    }
}
