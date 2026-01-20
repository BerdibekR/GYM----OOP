package com.berdibek.gym;

public class PremiumMember extends Member {

    private boolean personalTrainerAccess;

    public PremiumMember(int id, String name, int age, String membershipType, boolean trainerAccess) {
        super(id, name, age, membershipType);
        setPersonalTrainerAccess(trainerAccess);
    }

    public void setPersonalTrainerAccess(boolean access) {
        this.personalTrainerAccess = access;
    }

    public boolean hasTrainerAccess() {
        return personalTrainerAccess;
    }

    @Override
    public void workout() {
        System.out.println("Premium member " + name +
                " is training in VIP zone with advanced equipment.");
    }

    @Override
    public String getRole() {
        return "Premium Member";
    }

    @Override
    public String toString() {
        return super.toString() +
                " | Trainer Access: " +
                (personalTrainerAccess ? "Yes" : "No");
    }
}