package com.berdibek.gym;

public class Member {

    protected int memberId;
    protected String name;
    protected int age;
    protected String membershipType;

    public Member(int memberId, String name, int age, String membershipType) {
        this.memberId = memberId;
        setName(name);
        setAge(age);
        setMembershipType(membershipType);
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println(" Name cannot be empty. Setting to 'Unknown'.");
            this.name = "Unknown";
        }
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println(" Age cannot be negative. Setting to 0.");
            this.age = 0;
        }
    }

    public void setMembershipType(String membershipType) {
        if (membershipType != null && !membershipType.trim().isEmpty()) {
            this.membershipType = membershipType;
        } else {
            System.out.println(" Membership type cannot be empty. Setting to 'None'.");
            this.membershipType = "None";
        }
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
                " (ID: " + memberId + ", Age: " + age +
                ", Type: " + membershipType + ")";
    }
}
