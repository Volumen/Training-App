package pl.pawpam.engineeringproject.training;

import com.sun.istack.NotNull;
import pl.pawpam.engineeringproject.training.Exercise.Exercise;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "training")
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "training_id")
    private Long trainingId;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "exercises_to_training", joinColumns = @JoinColumn(name = "training_id"), inverseJoinColumns = @JoinColumn(name = "exercise_id"))
    private List<Exercise> exerciseList;

    @Column(name = "sets")
    @NotNull
    private int sets;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "training_name")
    @NotNull
    private String trainingName;

    @Column(name = "breaks")
    @NotNull
    private int breaksBetweenExercises;

    @Column(name = "level")
    @NotNull
    private int level;

    @Column(name = "full_time")
    private int fullTimeOfTraining;

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    public Training(List<Exercise> exerciseList, int sets, Long userId, String trainingName, int breaksBetweenExercises, int level, int fullTimeOfTraining) {
        this.exerciseList = exerciseList;
        this.sets = sets;
        this.userId = userId;
        this.trainingName = trainingName;
        this.breaksBetweenExercises = breaksBetweenExercises;
        this.level = level;
        this.fullTimeOfTraining = fullTimeOfTraining;
    }

    public Training(List<Exercise> exerciseList, String trainingName, int breaksBetweenExercises, int level, int sets) {
        this.exerciseList = exerciseList;
        this.trainingId = trainingId;
        this.trainingName = trainingName;
        this.breaksBetweenExercises = breaksBetweenExercises;
        this.level = level;
        this.sets = sets;
    }

//    public Training(List<Exercise> exerciseList, int sets, Long userId, String trainingName, int breaksBetweenExercises, int level) {
//        this.exerciseList = exerciseList;
//        this.sets = sets;
//        this.userId = userId;
//        this.trainingName = trainingName;
//        this.breaksBetweenExercises = breaksBetweenExercises;
//        this.level = level;
//    }

    public Training(List<Exercise> exerciseList, int breaksBetweenExercises, int level) {
        this.exerciseList = exerciseList;
        this.trainingId = trainingId;
        this.breaksBetweenExercises = breaksBetweenExercises;
        this.level = level;
    }

    public Training(List<Exercise> exerciseList, int sets, String trainingName, int breaksBetweenExercises, int level) {
        this.exerciseList = exerciseList;
        this.sets = sets;
        this.trainingName = trainingName;
        this.breaksBetweenExercises = breaksBetweenExercises;
        this.level = level;
    }

    public Training(int sets, String trainingName, int breaksBetweenExercises, int level) {
        this.sets = sets;
        this.trainingName = trainingName;
        this.breaksBetweenExercises = breaksBetweenExercises;
        this.level = level;
    }

    public Training() {
    }

    public int getFullTimeOfTraining() {
        return fullTimeOfTraining;
    }

    public void setFullTimeOfTraining(int fullTimeOfTraining) {
        this.fullTimeOfTraining = fullTimeOfTraining;
    }

    public List<Exercise> getExerciseList() {
        return exerciseList;
    }

    public void setExerciseList(List<Exercise> exerciseList) {
        this.exerciseList = exerciseList;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(Long trainingId) {
        this.trainingId = trainingId;
    }

    public int getBreaksBetweenExercises() {
        return breaksBetweenExercises;
    }

    public void setBreaksBetweenExercises(int breaksBetweenExercises) {
        this.breaksBetweenExercises = breaksBetweenExercises;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    @Override
    public String toString() {
        return "Training{" +
                "trainingId=" + trainingId +
                ", sets=" + sets +
                ", userId=" + userId +
                ", trainingName='" + trainingName + '\'' +
                ", breaksBetweenExercises=" + breaksBetweenExercises +
                ", level=" + level +
                '}';
    }
}
