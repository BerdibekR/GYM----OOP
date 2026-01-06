package com.berdibek.gym;

public class YogaSession extends WorkoutSession {

    private String difficultyLevel;
    private boolean meditationIncluded;

    public YogaSession(int id, String memberName, String trainerName, int duration, boolean completed, String difficultyLevel, boolean meditationIncluded) {

        super(id, memberName, trainerName, duration, completed);
        this.difficultyLevel = difficultyLevel;
        this.meditationIncluded = meditationIncluded;
    }

    @Override
    public void start() {
        System.out.println(memberName +
                " has started a " + difficultyLevel +
                " yoga session" +
                (meditationIncluded ? " with meditation." : "."));
    }

    @Override
    public String getType() {
        return "Yoga Session";
    }

    public boolean isMeditationClass() {
        return meditationIncluded;
    }

    public boolean isAdvancedLevel() {
        return difficultyLevel.equalsIgnoreCase("Advanced");
    }

    @Override
    public String toString() {
        return super.toString() +
                " | Level: " + difficultyLevel +
                " | Meditation: " + (meditationIncluded ? "Yes" : "No");
    }
}