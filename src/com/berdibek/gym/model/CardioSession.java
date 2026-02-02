package com.berdibek.gym.model;

import com.berdibek.gym.exception.InvalidInputException;

public class CardioSession extends WorkoutSession {

    private int caloriesTarget;

    public CardioSession(int id, String memberName, String trainerName,
                         int duration, boolean completed, int caloriesTarget)
            throws InvalidInputException {

        super(id, memberName, trainerName, duration, completed);
        setCaloriesTarget(caloriesTarget);
    }

    public void setCaloriesTarget(int caloriesTarget) throws InvalidInputException {
        if (caloriesTarget < 50) {
            throw new InvalidInputException("Calories target must be at least 50.");
        }
        this.caloriesTarget = caloriesTarget;
    }

    public int getCaloriesTarget() {
        return caloriesTarget;
    }

    @Override
    public void start() {
        System.out.println(memberName +
                " started an intensive cardio workout. Target = " +
                caloriesTarget + " calories.");
    }

    @Override
    public String getType() {
        return "Cardio Workout";
    }

    public boolean isFatBurnMode() {
        return caloriesTarget > 400;
    }

    @Override
    public String toString() {
        return super.toString() + " | Calories Target: " + caloriesTarget;
    }
}