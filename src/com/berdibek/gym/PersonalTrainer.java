package com.berdibek.gym;

public class PersonalTrainer extends Trainer {

    private int clientsCount;

    public PersonalTrainer(int id, String name, String specialization, int experienceYears, int clientsCount) {
        super(id, name, specialization, experienceYears);
        this.clientsCount = clientsCount;
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