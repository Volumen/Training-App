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
import pl.pawpam.engineeringproject.gui.admin.exercises.ExerciseManageGui;
import pl.pawpam.engineeringproject.gui.admin.users.UsersManageGui;
import pl.pawpam.engineeringproject.gui.menu.Menu;
import pl.pawpam.engineeringproject.training.Exercise.ExerciseService;
import pl.pawpam.engineeringproject.training.TrainingService;
import pl.pawpam.engineeringproject.user.UserService;

//@Secured(value = "ROLE_ADMIN")
@Route("admin")
public class AdminPanelGui extends VerticalLayout {
    private UserService userService;
    private Menu menu;
    private Label adminLabel;
    private AdminServiceImpl adminService;
    private ExerciseService exerciseService;
    private TrainingService trainingService;
    private Button exercisesButton;
    private Button trainingsButton;
    private Button usersButton;
    private HorizontalLayout horizontalLayout;
    private VerticalLayout mainAdminVerticalLayout;

    @Autowired
    public AdminPanelGui(UserService userService, AdminServiceImpl adminService, ExerciseService exerciseService, TrainingService trainingService) {
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


        //userTab.addAttachListener( event -> userTab.getUI().ifPresent(ui -> ui.navigate("admin/exercise")));

//        exercisesButton.addClickListener(event -> {
//
//        });
//        trainingsButton.addClickListener(event -> {
//            trainingsButton.getUI().ifPresent(ui -> ui.navigate("admin/training"));
//        });
//        usersButton.addClickListener(event -> {
//            usersButton.getUI().ifPresent(ui -> ui.navigate("admin/users"));
//        });

       // horizontalLayout.add(exercisesButton,trainingsButton,usersButton);


        add(menu,adminLabel,tabs,mainAdminVerticalLayout);
    }
}
