package com.berdibek.gym.model;

import com.berdibek.gym.exception.InvalidInputException;

public class GroupTrainer extends Trainer {

    private int groupSize;

    public GroupTrainer(int id, String name, String specialization,
                        int experienceYears, int groupSize)
            throws InvalidInputException {

        super(id, name, specialization, experienceYears);
        setGroupSize(groupSize);
    }

    public void setGroupSize(int groupSize) throws InvalidInputException {
        if (groupSize < 1) {
            throw new InvalidInputException("Group size must be at least 1.");
        }
        this.groupSize = groupSize;
    }

    public int getGroupSize() {
        return groupSize;
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