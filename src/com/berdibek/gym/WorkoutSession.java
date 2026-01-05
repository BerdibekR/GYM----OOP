package com.berdibek.gym;

public class WorkoutSession {

    protected int sessionId;
    protected String memberName;
    protected String trainerName;
    protected int durationMinutes;
    protected boolean completed;

    public WorkoutSession(int sessionId, String memberName, String trainerName, int durationMinutes, boolean completed) {

        this.sessionId = sessionId;
        this.memberName = memberName;
        this.trainerName = trainerName;
        this.durationMinutes = durationMinutes;
        this.completed = completed;
    }

    // ---------- METHODS TO OVERRIDE ----------
    public void start() {
        System.out.println("Workout session for " + memberName + " has started.");
    }

    public String getType() {
        return "General Workout";
    }

    public boolean isLongSession() {
        return durationMinutes >= 60;
    }

    @Override
    public String toString() {
        return "[" + getType() + "] " + memberName +
                " | Trainer: " + trainerName +
                " | Duration: " + durationMinutes + " min" +
                " | Completed: " + completed;
    }
}