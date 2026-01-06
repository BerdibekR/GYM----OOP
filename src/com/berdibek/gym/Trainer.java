package com.berdibek.gym;

public class Trainer {

    protected int trainerId;
    protected String name;
    protected String specialization;
    protected int experienceYears;

    public Trainer(int trainerId, String name, String specialization, int experienceYears) {

        this.trainerId = trainerId;
        this.name = name;
        this.specialization = specialization;
        this.experienceYears = experienceYears;
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