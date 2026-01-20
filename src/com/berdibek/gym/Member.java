package com.berdibek.gym;

public abstract class Member {

    protected int memberId;
    protected String name;
    protected int age;
    protected String membershipType;

    public Member(int memberId, String name, int age, String membershipType) {
        setMemberId(memberId);
        setName(name);
        setAge(age);
        setMembershipType(membershipType);
    }

    public abstract void workout();
    public abstract String getRole();

    public void setMemberId(int memberId) {
        if (memberId <= 0) {
            throw new IllegalArgumentException("Member ID must be positive.");
        }
        this.memberId = memberId;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative.");
        }
        this.age = age;
    }

    public void setMembershipType(String membershipType) {
        if (membershipType == null || membershipType.trim().isEmpty()) {
            throw new IllegalArgumentException("Membership type cannot be empty.");
        }
        this.membershipType = membershipType;
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
                " (ID: " + memberId + ", Age: " + age +
                ", Type: " + membershipType + ")";
    }
}
