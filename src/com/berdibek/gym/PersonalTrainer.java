package com.berdibek.gym;

import exception.InvalidInputException;

public class PersonalTrainer extends Trainer {

    private int clientsCount;

    public PersonalTrainer(int id, String name, String specialization,
                           int experienceYears, int clientsCount)
            throws InvalidInputException {

        super(id, name, specialization, experienceYears);
        setClientsCount(clientsCount);
    }

    public void setClientsCount(int clientsCount) throws InvalidInputException {
        if (clientsCount < 0)
            throw new InvalidInputException("Clients count cannot be negative.");
        this.clientsCount = clientsCount;
    }

    @Override
    public void conductSession() {
        System.out.println("Personal Trainer " + name + " is coaching 1-on-1.");
    }

    @Override
    public String getRole() {
        return "Personal Trainer";
    }
}