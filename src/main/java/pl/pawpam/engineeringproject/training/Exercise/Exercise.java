package pl.pawpam.engineeringproject.training.Exercise;

import com.sun.istack.NotNull;
import com.vaadin.flow.component.html.Image;

import javax.persistence.*;

@Entity
@Table(name = "Exercise")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "exercise_id")
    private int id;

    @Column(name = "exercise_name")
    @NotNull
    private String exerciseName;

    @Column(name = "exercise_level")
    @NotNull
    private int level;

    @Column(name = "exercise_info")
    @NotNull
    private String info;

    @Column(name = "img_path")
    @NotNull
    private String imgPath;

    @Column(name = "reps")
    private int reps;

    public Exercise(int id, String exerciseName, int level, String info, String imgPath, int reps) {
        this.id = id;
        this.exerciseName = exerciseName;
        this.level = level;
        this.info = info;
        this.imgPath = imgPath;
        this.reps = reps;
    }

    public Exercise(String exerciseName, int level, String info, String imgPath) {
        this.exerciseName = exerciseName;
        this.level = level;
        this.info = info;
        this.imgPath = imgPath;
    }

    public Exercise(int id, String exerciseName, int level, String info, int reps) {
        this.id = id;
        this.exerciseName = exerciseName;
        this.level = level;
        this.info = info;
        this.reps = reps;
    }

    public Exercise(int id, String exerciseName, int level, String info) {
        this.id = id;
        this.exerciseName = exerciseName;
        this.level = level;
        this.info = info;
    }

    public Exercise() {
    }

    public Exercise(String exerciseName, int level, String info, String imgPath, int reps) {
        this.exerciseName = exerciseName;
        this.level = level;
        this.info = info;
        this.imgPath = imgPath;
        this.reps = reps;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return
                "exerciseName='" + exerciseName ;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }
}
