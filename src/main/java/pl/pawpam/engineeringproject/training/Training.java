package pl.pawpam.engineeringproject.training;

import javax.persistence.Entity;
import java.util.List;
import java.util.Map;


public class Training {

    private List<Exercise> exerciseList;
    private int sets;
    private Long userId;
    private Long trainingId;
    private String trainingName;
    private int breaksBetweenExercises;
    private int level;

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    public Training(List<Exercise> exerciseList, Long trainingId, String trainingName, int breaksBetweenExercises, int level, int sets) {
        this.exerciseList = exerciseList;
        this.trainingId = trainingId;
        this.trainingName = trainingName;
        this.breaksBetweenExercises = breaksBetweenExercises;
        this.level = level;
        this.sets = sets;
    }

    public Training(List<Exercise> exerciseList, Long trainingId, int breaksBetweenExercises, int level) {
        this.exerciseList = exerciseList;
        this.trainingId = trainingId;
        this.breaksBetweenExercises = breaksBetweenExercises;
        this.level = level;
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
                "exerciseList=" + exerciseList +
                ", userId=" + userId +
                ", trainingId=" + trainingId +
                ", trainingName='" + trainingName + '\'' +
                ", breaksBetweenExercises=" + breaksBetweenExercises +
                ", level=" + level +
                '}';
    }
}
