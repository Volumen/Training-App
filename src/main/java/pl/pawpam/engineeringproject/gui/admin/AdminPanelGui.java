package pl.pawpam.engineeringproject.gui.admin;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import pl.pawpam.engineeringproject.admin.AdminServiceImpl;
import pl.pawpam.engineeringproject.admin.AdminServiceInterface;
import pl.pawpam.engineeringproject.gui.admin.exercises.ExerciseManageGui;
import pl.pawpam.engineeringproject.gui.admin.users.UsersManageGui;
import pl.pawpam.engineeringproject.gui.menu.Menu;
import pl.pawpam.engineeringproject.training.Exercise.ExerciseService;
import pl.pawpam.engineeringproject.training.Exercise.ExerciseServiceInterface;
import pl.pawpam.engineeringproject.training.TrainingService;
import pl.pawpam.engineeringproject.training.TrainingServiceInterface;
import pl.pawpam.engineeringproject.user.UserService;
import pl.pawpam.engineeringproject.user.UserServiceInterface;

//@Secured(value = "ROLE_ADMIN")
@Route("admin")
public class AdminPanelGui extends VerticalLayout {
    private UserServiceInterface userService;
    private Menu menu;
    private Label adminLabel;
    private AdminServiceInterface adminService;
    private ExerciseServiceInterface exerciseService;
    private TrainingServiceInterface trainingService;
    private VerticalLayout mainAdminVerticalLayout;

    @Autowired
    public AdminPanelGui(UserServiceInterface userService, AdminServiceInterface adminService, ExerciseServiceInterface exerciseService, TrainingServiceInterface trainingService) {
        this.userService = userService;
        this.adminService = adminService;
        this.exerciseService = exerciseService;
        this.trainingService = trainingService;
        menu = new Menu(userService);
        adminLabel = new Label("Administration");
//        exercisesButton = new Button("Manage Exercises");
//        trainingsButton = new Button("Manage Trainings");
//        usersButton = new Button("Manage Users");
//        horizontalLayout = new HorizontalLayout();
        mainAdminVerticalLayout = new VerticalLayout();
        mainAdminVerticalLayout.setWidth("70%");
        this.setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        //Initialize views
        Component userView = new UsersManageGui(adminService);
        Component exercisesView = new ExerciseManageGui(exerciseService);
        //Component trainingsView = new UsersManageGui();


        Tab userTab = new Tab("Manage Users");
        Tab exerciseTab = new Tab("Manage Exersises");
        Tab trainingTab = new Tab("Manage Trainings");
        Tabs tabs = new Tabs();
        tabs.add(userTab,exerciseTab,trainingTab);
        tabs.setSelectedTab(userTab);
        tabs.setFlexGrowForEnclosedTabs(1);
        mainAdminVerticalLayout.add(userView);
        tabs.addSelectedChangeListener(event ->
        {
            mainAdminVerticalLayout.removeAll();
            if(event.getSelectedTab().equals(userTab))
            {
                mainAdminVerticalLayout.add(userView);
            }
            else if (event.getSelectedTab().equals(exerciseTab))
            {
                mainAdminVerticalLayout.add(exercisesView);
            }
        });



        add(menu,adminLabel,tabs,mainAdminVerticalLayout);
    }
}
