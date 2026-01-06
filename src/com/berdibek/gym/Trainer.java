package com.berdibek.gym;

public class Trainer {

    protected int trainerId;
    protected String name;
    protected String specialization;
    protected int experienceYears;

    public Trainer(int trainerId, String name, String specialization, int experienceYears) {
        this.trainerId = trainerId;
        setName(name);
        setSpecialization(specialization);
        setExperienceYears(experienceYears);
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println(" Name cannot be empty. Setting to 'Unknown Trainer'.");
            this.name = "Unknown Trainer";
        }
    }

    public void setSpecialization(String specialization) {
        if (specialization != null && !specialization.trim().isEmpty()) {
            this.specialization = specialization;
        } else {
            System.out.println(" Specialization cannot be empty. Setting to 'General Fitness'.");
            this.specialization = "General Fitness";
        }
    }

    public void setExperienceYears(int experienceYears) {
        if (experienceYears >= 0) {
            this.experienceYears = experienceYears;
        } else {
            System.out.println(" Experience cannot be negative. Setting to 0.");
            this.experienceYears = 0;
        }
    }

    public void conductSession() {
        System.out.println("Trainer " + name + " is conducting a general workout session.");
    }

    public String getRole() {
        return "Trainer";
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