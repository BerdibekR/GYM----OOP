package com.berdibek.gym.model;

import com.berdibek.gym.exception.InvalidInputException;

public abstract class Member {

    protected int memberId;
    protected String name;
    protected int age;
    protected String membershipType;

    public Member(int memberId, String name, int age, String membershipType)
            throws InvalidInputException {

        setMemberId(memberId);
        setName(name);
        setAge(age);
        setMembershipType(membershipType);
    }

    public abstract void workout();
    public abstract String getRole();

    public void setMemberId(int memberId) throws InvalidInputException {
        if (memberId <= 0)
            throw new InvalidInputException("Member ID must be positive.");
        this.memberId = memberId;
    }

    public void setName(String name) throws InvalidInputException {
        if (name == null || name.trim().isEmpty())
            throw new InvalidInputException("Name cannot be empty.");
        this.name = name;
    }

    public void setAge(int age) throws InvalidInputException {
        if (age < 0)
            throw new InvalidInputException("Age cannot be negative.");

        if (age > 120)
            throw new IllegalArgumentException("Age too big.");

        this.age = age;
    }

    public void setMembershipType(String membershipType) throws InvalidInputException {
        if (membershipType == null || membershipType.trim().isEmpty())
            throw new InvalidInputException("Membership type cannot be empty.");
        this.membershipType = membershipType;
    }

    @Override
    public String toString() {
        return "[" + getRole() + "] " + name +
                " (ID: " + memberId +
                ", Age: " + age +
                ", Type: " + membershipType + ")";
    }
}