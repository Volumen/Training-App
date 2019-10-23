package pl.pawpam.engineeringproject.training;

import javax.persistence.Entity;
import java.util.List;

public class Training {

    private List<Exercise> exerciseList;
    private Long userId;
    private Integer reps;
}
