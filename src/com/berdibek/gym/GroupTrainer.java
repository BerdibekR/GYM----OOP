package com.berdibek.gym;

public class GroupTrainer extends Trainer {

    private int groupSize;

    public GroupTrainer(int id, String name, String specialization,
                        int experienceYears, int groupSize) {
        super(id, name, specialization, experienceYears);
        this.groupSize = groupSize;
    }

    @Override
    public void conductSession() {
        System.out.println("Group Trainer " + name +
                " is leading a group workout for " + groupSize + " people.");
    }

    @Override
    public String getRole() {
        return "Group Trainer";
    }

    public boolean isPopularInstructor() {
        return groupSize >= 15;
    }

    @Override
    public String toString() {
        return super.toString() + " | Group Size: " + groupSize;
    }
}