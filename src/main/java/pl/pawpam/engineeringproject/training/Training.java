package pl.pawpam.engineeringproject.training;

import javax.persistence.Entity;
import java.util.List;
import java.util.Map;


public class Training {

    private List<Exercise> exerciseList;
    private int reps;
    private Long userId;
    private int breaksBetweenExercises;
    private int level;

    public Training(List<Exercise> exerciseList, int reps, int breaksBetweenExercises, int level) {
        this.exerciseList = exerciseList;
        this.reps = reps;
        this.breaksBetweenExercises = breaksBetweenExercises;
        this.level = level;
    }

    @Override
    public String toString() {
        return "Training{" +
                "exerciseList=" + exerciseList +
                ", reps=" + reps +
                ", userId=" + userId +
                ", breaksBetweenExercises=" + breaksBetweenExercises +
                ", level=" + level +
                '}';
    }

    public List<Exercise> getExerciseList() {
        return exerciseList;
    }

    public void setExerciseList(List<Exercise> exerciseList) {
        this.exerciseList = exerciseList;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
}
