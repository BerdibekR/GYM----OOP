package com.berdibek.gym;

public abstract class Trainer {

    protected int trainerId;
    protected String name;
    protected String specialization;
    protected int experienceYears;

    public Trainer(int trainerId, String name, String specialization, int experienceYears) {
        setTrainerId(trainerId);
        setName(name);
        setSpecialization(specialization);
        setExperienceYears(experienceYears);
    }

    public abstract void conductSession();
    public abstract String getRole();

    public void setTrainerId(int trainerId) {
        if (trainerId <= 0) {
            throw new IllegalArgumentException("Trainer ID must be positive.");
        }
        this.trainerId = trainerId;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Trainer name cannot be empty.");
        }
        this.name = name;
    }

    public void setSpecialization(String specialization) {
        if (specialization == null || specialization.trim().isEmpty()) {
            throw new IllegalArgumentException("Specialization cannot be empty.");
        }
        this.specialization = specialization;
    }

    public void setExperienceYears(int experienceYears) {
        if (experienceYears < 0) {
            throw new IllegalArgumentException("Experience years cannot be negative.");
        }
        this.experienceYears = experienceYears;
    }

    public boolean isSeniorCoach() {
        return experienceYears >= 5;
    }

    @Override
    public String toString() {
        return "[" + getRole() + "] " + name +
                " (ID: " + trainerId +
                ", Spec: " + specialization +
                ", Exp: " + experienceYears + " yrs)";
    }
}