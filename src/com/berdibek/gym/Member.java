package com.berdibek.gym;

public class Member {

    protected int memberId;
    protected String name;
    protected int age;
    protected String membershipType;

    public Member(int memberId, String name, int age, String membershipType) {
        this.memberId = memberId;
        this.name = name;
        this.age = age;
        this.membershipType = membershipType;
    }

    public void workout() {
        System.out.println(name + " is doing a regular workout.");
    }

    public String getRole() {
        return "Gym Member";
    }

    public boolean isAdult() {
        return age >= 18;
    }

    public boolean isActive() {
        return !membershipType.equalsIgnoreCase("None");
    }

    public void upgrade() {
        membershipType = "Premium";
    }

    @Override
    public String toString() {
        return "[" + getRole() + "] " + name +
                " (ID: " + memberId +
                ", Age: " + age +
                ", Type: " + membershipType + ")";
    }
}