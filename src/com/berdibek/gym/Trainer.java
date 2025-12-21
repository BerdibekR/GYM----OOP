package com.berdibek.gym;

public class Trainer {
    private int trainerId;
    private String name;
    private String specialization;
    private int experience;

    public Trainer(int trainerId, String name, String specialization, int experience) {
        this.trainerId = trainerId;
        this.name = name;
        this.specialization = specialization;
        this.experience = experience;
    }

    public Trainer() {
        this.trainerId = 0;
        this.name = "Unknown Name";
        this.specialization = "General";
        this.experience = 0;
    }

    public int getTrainerId() {
        return trainerId;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public int getExperience() {
        return experience;
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public boolean isExperienced() {
        return experience >= 5;
    }

    public boolean canTeach(String trainingType) {
        return specialization.equalsIgnoreCase(trainingType);
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "trainerId=" + trainerId +
                ", name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", experience=" + experience +
                '}';
    }
}