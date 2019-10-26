package pl.pawpam.engineeringproject.training;

import com.sun.istack.NotNull;
import com.vaadin.flow.component.html.Image;

import javax.persistence.*;

@Entity
@Table(name = "Exercise")
public class Exercise {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
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
    private Image imgPath;

    public Exercise(String exerciseName, int level, String info, Image imgPath) {
        this.exerciseName = exerciseName;
        this.level = level;
        this.info = info;
        this.imgPath = imgPath;
    }

    public Exercise(int id, String exerciseName, int level, String info, Image imgPath) {
        this.id = id;
        this.exerciseName = exerciseName;
        this.level = level;
        this.info = info;
        this.imgPath = imgPath;
    }

    public Exercise() {
    }

    public Image getImgPath() {
        return imgPath;
    }

    public void setImgPath(Image imgPath) {
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
}
