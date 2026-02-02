package com.berdibek.gym.model;

import com.berdibek.gym.exception.InvalidInputException;

public class StudentMember extends Member {

    private String university;

    public StudentMember(int id, String name, int age, String membershipType, String university)
            throws InvalidInputException {

        super(id, name, age, membershipType);
        setUniversity(university);
    }

    public void setUniversity(String university) throws InvalidInputException {
        if (university == null || university.trim().isEmpty())
            throw new InvalidInputException("University cannot be empty.");
        this.university = university;
    }

    @Override
    public void workout() {
        System.out.println("Student " + name + " is training after classes.");
    }

    @Override
    public String getRole() {
        return "Student Member";
    }
}