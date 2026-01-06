package com.berdibek.gym;

public class WorkoutSession {

    protected int sessionId;
    protected String memberName;
    protected String trainerName;
    protected int durationMinutes;
    protected boolean completed;

    public WorkoutSession(int sessionId, String memberName, String trainerName, int durationMinutes, boolean completed) {

        this.sessionId = sessionId;
        setMemberName(memberName);
        setTrainerName(trainerName);
        setDurationMinutes(durationMinutes);
        setCompleted(completed);
    }

    public void setMemberName(String memberName) {
        if (memberName != null && !memberName.trim().isEmpty()) {
            this.memberName = memberName;
        } else {
            System.out.println(" Member name cannot be empty. Setting to 'Unknown Member'.");
            this.memberName = "Unknown Member";
        }
    }

    public void setTrainerName(String trainerName) {
        if (trainerName != null && !trainerName.trim().isEmpty()) {
            this.trainerName = trainerName;
        } else {
            System.out.println(" Trainer name cannot be empty. Setting to 'Unknown Trainer'.");
            this.trainerName = "Unknown Trainer";
        }
    }

    public void setDurationMinutes(int durationMinutes) {
        if (durationMinutes > 0) {
            this.durationMinutes = durationMinutes;
        } else {
            System.out.println(" Duration must be greater than 0. Setting to 30 by default.");
            this.durationMinutes = 30;
        }
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

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