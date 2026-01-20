package com.berdibek.gym;

public abstract class WorkoutSession {

    protected int sessionId;
    protected String memberName;
    protected String trainerName;
    protected int durationMinutes;
    protected boolean completed;

    public WorkoutSession(int sessionId, String memberName, String trainerName,
                          int durationMinutes, boolean completed) {

        setSessionId(sessionId);
        setMemberName(memberName);
        setTrainerName(trainerName);
        setDurationMinutes(durationMinutes);
        setCompleted(completed);
    }

    public abstract void start();
    public abstract String getType();

    public void setSessionId(int sessionId) {
        if (sessionId <= 0) {
            throw new IllegalArgumentException("Session ID must be positive.");
        }
        this.sessionId = sessionId;
    }

    public void setMemberName(String memberName) {
        if (memberName == null || memberName.trim().isEmpty()) {
            throw new IllegalArgumentException("Member name cannot be empty.");
        }
        this.memberName = memberName;
    }

    public void setTrainerName(String trainerName) {
        if (trainerName == null || trainerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Trainer name cannot be empty.");
        }
        this.trainerName = trainerName;
    }

    public void setDurationMinutes(int durationMinutes) {
        if (durationMinutes <= 0) {
            throw new IllegalArgumentException("Duration must be greater than 0.");
        }
        this.durationMinutes = durationMinutes;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
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