package com.berdibek.gym;

import exception.InvalidInputException;

public class PremiumMember extends Member {

    private boolean personalTrainerAccess;

    public PremiumMember(int id, String name, int age, String membershipType, boolean trainerAccess)
            throws InvalidInputException {

        super(id, name, age, membershipType);
        this.personalTrainerAccess = trainerAccess;
    }

    @Override
    public void workout() {
        System.out.println("Premium " + name + " is training in VIP zone.");
    }

    @Override
    public String getRole() {
        return "Premium Member";
    }
}