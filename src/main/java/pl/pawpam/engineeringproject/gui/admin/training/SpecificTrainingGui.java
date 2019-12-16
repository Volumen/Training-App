package pl.pawpam.engineeringproject.gui.admin.training;

import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.pawpam.engineeringproject.training.TrainingServiceInterface;

@Route("admin/exercise")
public class SpecificTrainingGui {
    private TrainingServiceInterface trainingServiceInterface;

    @Autowired
    public SpecificTrainingGui(TrainingServiceInterface trainingServiceInterface) {
        this.trainingServiceInterface = trainingServiceInterface;
    }
}
