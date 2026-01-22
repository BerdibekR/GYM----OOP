package com.berdibek.gym;

import exception.InvalidInputException;

public abstract class Trainer {

    protected int trainerId;
    protected String name;
    protected String specialization;
    protected int experienceYears;

    public Trainer(int trainerId, String name, String specialization, int experienceYears)
            throws InvalidInputException {

        setTrainerId(trainerId);
        setName(name);
        setSpecialization(specialization);
        setExperienceYears(experienceYears);
    }

    public abstract void conductSession();
    public abstract String getRole();

    public void setTrainerId(int trainerId) throws InvalidInputException {
        if (trainerId <= 0)
            throw new InvalidInputException("Trainer ID must be positive.");
        this.trainerId = trainerId;
    }

    public void setName(String name) throws InvalidInputException {
        if (name == null || name.trim().isEmpty())
            throw new InvalidInputException("Trainer name cannot be empty.");
        this.name = name;
    }

    public void setSpecialization(String specialization) throws InvalidInputException {
        if (specialization == null || specialization.trim().isEmpty())
            throw new InvalidInputException("Specialization cannot be empty.");
        this.specialization = specialization;
    }

    public void setExperienceYears(int experienceYears) throws InvalidInputException {
        if (experienceYears < 0)
            throw new InvalidInputException("Experience cannot be negative.");
        this.experienceYears = experienceYears;
    }
}