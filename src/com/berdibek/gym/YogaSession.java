package com.berdibek.gym;

public class YogaSession extends WorkoutSession {

    private String difficultyLevel;
    private boolean meditationIncluded;

    public YogaSession(int id, String memberName, String trainerName,
                       int duration, boolean completed,
                       String difficultyLevel, boolean meditationIncluded) {

        super(id, memberName, trainerName, duration, completed);
        setDifficultyLevel(difficultyLevel);
        setMeditationIncluded(meditationIncluded);
    }

    public void setDifficultyLevel(String difficultyLevel) {
        if (difficultyLevel == null || difficultyLevel.trim().isEmpty()) {
            throw new IllegalArgumentException("Difficulty level cannot be empty.");
        }
        this.difficultyLevel = difficultyLevel;
    }

    public void setMeditationIncluded(boolean meditationIncluded) {
        this.meditationIncluded = meditationIncluded;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public boolean isMeditationIncluded() {
        return meditationIncluded;
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