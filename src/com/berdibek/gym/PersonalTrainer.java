package com.berdibek.gym;

public class PersonalTrainer extends Trainer {

    private int clientsCount;

    public PersonalTrainer(int id, String name, String specialization, int experienceYears, int clientsCount) {
        super(id, name, specialization, experienceYears);
        setClientsCount(clientsCount);
    }

    public void setClientsCount(int clientsCount) {
        if (clientsCount < 0) {
            throw new IllegalArgumentException("Clients count cannot be negative.");
        }
        this.clientsCount = clientsCount;
    }

    public int getClientsCount() {
        return clientsCount;
    }

    @Override
    public void conductSession() {
        System.out.println("Personal Trainer " + name +
                " is coaching a one-on-one training session.");
    }

    @Override
    public String getRole() {
        return "Personal Trainer";
    }

    public boolean isEliteCoach() {
        return clientsCount > 20 && experienceYears >= 5;
    }

    @Override
    public String toString() {
        return super.toString() + " | Clients: " + clientsCount;
    }
}