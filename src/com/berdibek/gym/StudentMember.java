package com.berdibek.gym;

public class StudentMember extends Member {

    private String university;

    public StudentMember(int id, String name, int age, String membershipType, String university) {
        super(id, name, age, membershipType);
        setUniversity(university);
    }

    public void setUniversity(String university) {
        if (university != null && !university.trim().isEmpty()) {
            this.university = university;
        } else {
            System.out.println(" University cannot be empty. Setting to 'Unknown University'.");
            this.university = "Unknown University";
        }
    }

    public String getUniversity() {
        return university;
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