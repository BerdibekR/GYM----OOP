package com.berdibek.gym.model;

import exception.InvalidInputException;

public abstract class WorkoutSession {

    protected int sessionId;
    protected String memberName;
    protected String trainerName;
    protected int durationMinutes;
    protected boolean completed;

    public WorkoutSession(int sessionId, String memberName, String trainerName,
                          int durationMinutes, boolean completed)
            throws InvalidInputException {

        setSessionId(sessionId);
        setMemberName(memberName);
        setTrainerName(trainerName);
        setDurationMinutes(durationMinutes);
        setCompleted(completed);
    }

    public abstract void start();
    public abstract String getType();

    public void setSessionId(int sessionId) throws InvalidInputException {
        if (sessionId <= 0) {
            throw new InvalidInputException("Session ID must be positive.");
        }
        this.sessionId = sessionId;
    }

    public void setMemberName(String memberName) throws InvalidInputException {
        if (memberName == null || memberName.trim().isEmpty()) {
            throw new InvalidInputException("Member name cannot be empty.");
        }
        this.memberName = memberName;
    }

    public void setTrainerName(String trainerName) throws InvalidInputException {
        if (trainerName == null || trainerName.trim().isEmpty()) {
            throw new InvalidInputException("Trainer name cannot be empty.");
        }
        this.trainerName = trainerName;
    }

    public void setDurationMinutes(int durationMinutes) throws InvalidInputException {
        if (durationMinutes <= 0) {
            throw new InvalidInputException("Duration must be greater than 0.");
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