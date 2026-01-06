package com.berdibek.gym;

public class CardioSession extends WorkoutSession {

    private int caloriesTarget;

    public CardioSession(int id, String memberName, String trainerName, int duration, boolean completed, int caloriesTarget) {

        super(id, memberName, trainerName, duration, completed);
        setCaloriesTarget(caloriesTarget);
    }

    public void setCaloriesTarget(int caloriesTarget) {
        if (caloriesTarget >= 50) {
            this.caloriesTarget = caloriesTarget;
        } else {
            System.out.println(" Calories target must be at least 50. Setting to 50.");
            this.caloriesTarget = 50;
        }
    }

    public int getCaloriesTarget() {
        return caloriesTarget;
    }

    @Override
    public void start() {
        System.out.println(memberName + " started an intensive cardio workout. Target = " + caloriesTarget + " calories.");
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