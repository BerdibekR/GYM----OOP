package com.berdibek.gym;

public class WorkoutSession {
    private int sessionId;
    private String memberName;
    private String trainer;
    private int duration;
    private boolean completed;

    public WorkoutSession(int sessionId, String memberName, String trainerName, int duration, boolean completed) {
        this.sessionId = sessionId;
        this.memberName = memberName;
        this.trainer = trainer;
        this.duration = duration;
        this.completed = completed;
    }

    public WorkoutSession() {
        this.sessionId = 0;
        this.memberName = "Unknown Name";
        this.trainer = "Unknown Name";
        this.duration = 0;
        this.completed = false;
    }

    public int getSessionId() {
        return sessionId;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getTrainer() {
        return trainer;
    }

    public int getDuration() {
        return duration;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void extend(int extraMinutes) {
        if (extraMinutes > 0) {
            this.duration += extraMinutes;
        }
    }

    public void complete() {
        this.completed = true;
    }

    @Override
    public String toString() {
        return "WorkoutSession{" +
                "sessionId=" + sessionId +
                ", memberName='" + memberName + '\'' +
                ", trainerName='" + trainer + '\'' +
                ", duration=" + duration +
                ", completed=" + completed +
                '}';
    }
}
