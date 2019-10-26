package pl.pawpam.engineeringproject.gui.admin.users;

import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.pawpam.engineeringproject.training.Exercise;
import pl.pawpam.engineeringproject.user.User;
import pl.pawpam.engineeringproject.user.UserServiceImpl;

import java.util.Optional;

@Route(value = "admin/user")
public class SpecificUserManageGui extends VerticalLayout implements HasUrlParameter<Long> {
    private Long id;
    private UserServiceImpl userService;
    private Label nameLabel;
    private Label lastNameLabel;
    private Label emailLabel;
    private Checkbox activeCheckbox;
    private ComboBox<String> roleComboBox;

    @Autowired
    public SpecificUserManageGui(UserServiceImpl userService) {
    this.userService = userService;
    nameLabel = new Label();
    lastNameLabel = new Label();
    emailLabel = new Label();
    activeCheckbox = new Checkbox();
    roleComboBox = new ComboBox<>();

    add(nameLabel,lastNameLabel,emailLabel,activeCheckbox,roleComboBox);

    }

    @Override
    public void setParameter(BeforeEvent beforeEvent, Long id) {
        this.id = id;
        Optional<User> userOptional = userService.getAllUsers().stream()
                .filter(user -> user.getId() == id)
                .findFirst();
//        System.out.println(exerciseOptional);
        userOptional.ifPresent(user ->
        {
            nameLabel.setText("Name: "+ user.getName());
            lastNameLabel.setText("Last Name: "+ user.getLastName());
            emailLabel.setText("Email: "+user.getEmail());
            roleComboBox.setLabel("Role");
            roleComboBox.setItems("Administrator","User");

            if(user.getActive()==1)
            {
                activeCheckbox.setValue(true);
                activeCheckbox.setLabel("Active");
            }
            else { activeCheckbox.setLabel("Non Active"); }
            if(user.getNrRoli()==1)
            {
                roleComboBox.setValue("Administrator");
            }
            else {roleComboBox.setValue("User");}



//            exerciseNameLabel.setText("Exercise name: " + exercise.getExerciseName());
//            exerciseIdLabel.setText("Id: " + exercise.getId());
//            exerciseLevelLabel.setText("Level: " + exercise.getLevel());
//            exerciseInfoLabel.setText("Info: " + exercise.getInfo());
        });
    }
}
