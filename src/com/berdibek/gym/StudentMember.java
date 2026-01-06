package com.berdibek.gym;

public class StudentMember extends Member {

    private String university;

    public StudentMember(int id, String name, int age, String membershipType, String university) {
        super(id, name, age, membershipType);
        this.university = university;
    }

    @Override
    public void workout() {
        System.out.println("Student " + name +
                " is training after classes at " + university + ".");
    }

    @Override
    public String getRole() {
        return "Student Member";
    }

    public boolean hasStudentDiscount() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + " | University: " + university;
    }
}