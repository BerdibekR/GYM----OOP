package com.berdibek.gym;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Gym Management System!");
        System.out.println("This project is designed to manage a modern fitness center.");
        System.out.println("The system will handle gym members and their memberships.");
        System.out.println("It will also manage trainers, member, and workoutsession.");
        System.out.println("Student: Rapikhov Berdibek, OOP Course.");

        Member member1 = new Member(1, "Arman", 23, "Basic");
        Member member2 = new Member(2, "Dastan", 19, "None");
        Member member3 = new Member();

        Trainer trainer1 = new Trainer(101, "Bagzhan", "Fitness", 6);
        Trainer trainer2 = new Trainer(102, "Aibek", "Yoga", 3);

        WorkoutSession session1 = new WorkoutSession(1001, "Arman", "Bagzhan", 60, false);
        WorkoutSession session2 = new WorkoutSession(1002, "Dastan", "Aibek", 30, false);

        System.out.println("--- MEMBERS ---");
        System.out.println(member1);
        System.out.println(member2);
        System.out.println(member3);
        System.out.println();

        System.out.println("--- TRAINERS ---");
        System.out.println(trainer1);
        System.out.println(trainer2);
        System.out.println();

        System.out.println("--- WORKOUT SESSIONS ---");
        System.out.println(session1);
        System.out.println(session2);
        System.out.println();

        System.out.println("--- TESTING GETTERS ---");
        System.out.println("Member1 name: " + member1.getName());
        System.out.println("Member1 age: " + member1.getAge());
        System.out.println("Trainer1 specialization: " + trainer1.getSpecialization());
        System.out.println("Session1 duration: " + session1.getDuration() + " minutes");
        System.out.println();

        System.out.println("--- TESTING SETTERS ---");
        member2.setMembershipType("Basic");
        trainer2.setExperience(5);
        session2.setMemberName("Dastan");
        session2.setTrainer("Aibek");
        session2.setDuration(45);

        System.out.println("Updated member2: " + member2);
        System.out.println("Updated trainer2: " + trainer2);
        System.out.println("Updated session2: " + session2);
        System.out.println();

        System.out.println("--- TESTING TRAINER METHODS ---");
        System.out.println(member1.getName() + " is active: " + member1.isActive());
        System.out.println("Upgrading membership for " + member1.getName());
        member1.upgrade();
        System.out.println("New membership type: " + member1.getMembershipType());
        System.out.println();

        System.out.println("--- TESTING WORKOUT SESSION METHODS ---");
        System.out.println("Session " + session1.getSessionId() + " completed: " + session1.isCompleted());
        System.out.println();

        System.out.println("Extending session " + session1.getSessionId() + " by 20 minutes");
        session1.extend(20);
        session1.complete();
        System.out.println("Session duration: " + session1.getDuration() + " minutes");
        System.out.println("Session completed: " + session1.isCompleted());
        System.out.println();

        System.out.println("--- FINAL STATE ---");
        System.out.println("Member:");
        System.out.println(member1);
        System.out.println(member2);
        System.out.println(member3);
        System.out.println();
        System.out.println("Trainer:");
        System.out.println(trainer1);
        System.out.println(trainer2);
        System.out.println();
        System.out.println("Workout Sessions:");
        System.out.println(session1);
        System.out.println(session2);

        System.out.println("\n=== PROGRAM COMPLETE ===");
    }
}