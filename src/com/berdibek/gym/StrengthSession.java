package com.berdibek.gym;

public class StrengthSession extends WorkoutSession {

    private String muscleGroup;

    public StrengthSession(int id, String memberName, String trainerName, int duration, boolean completed, String muscleGroup) {

        super(id, memberName, trainerName, duration, completed);
        setMuscleGroup(muscleGroup);
    }

    public void setMuscleGroup(String muscleGroup) {
        if (muscleGroup != null && !muscleGroup.trim().isEmpty()) {
            this.muscleGroup = muscleGroup;
        } else {
            System.out.println(" Muscle group cannot be empty. Setting to 'General'.");
            this.muscleGroup = "General";
        }
    }

    public String getMuscleGroup() {
        return muscleGroup;
    }

    @Override
    public void start() {
        System.out.println(memberName + " is doing strength training for: " + muscleGroup);
    }

    @Override
    public String getType() {
        return "Strength Workout";
    }

    public boolean isUpperBodyDay() {
        return muscleGroup.equalsIgnoreCase("Chest")
                || muscleGroup.equalsIgnoreCase("Back")
                || muscleGroup.equalsIgnoreCase("Arms");
    }

    @Override
    public String toString() {
        return super.toString() + " | Muscle Group: " + muscleGroup;
    }
}