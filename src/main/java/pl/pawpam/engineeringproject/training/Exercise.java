package pl.pawpam.engineeringproject.training;

import com.sun.istack.NotNull;

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

    public Exercise() {
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
