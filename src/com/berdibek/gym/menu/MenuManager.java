package com.berdibek.gym.menu;

import com.berdibek.gym.*;
import exception.InvalidInputException;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuManager implements Menu {

    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<Trainer> trainers = new ArrayList<>();
    private ArrayList<WorkoutSession> sessions = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public MenuManager() {
        seedData();
    }

    private void seedData() {
        try {
            members.add(new StudentMember(1, "Dastan", 19, "Student", "AITU"));
            members.add(new PremiumMember(2, "Aibek", 28, "Premium", true));
            members.add(new SeniorMember(3, "Samat", 61, "Senior", 60, 15));

            trainers.add(new PersonalTrainer(101, "Aidar", "Strength", 4, 12));
            trainers.add(new GroupTrainer(102, "Dana", "Yoga", 3, 18));

            sessions.add(new CardioSession(1001, "Dastan", "Aidar", 45, true, 380));
            sessions.add(new StrengthSession(1002, "Aibek", "Dana", 70, false, "Chest"));
            sessions.add(new YogaSession(1003, "Aruzhan", "Dana", 50, false, "Intermediate", true));

        } catch (InvalidInputException e) {
            System.out.println("Error while creating data: " + e.getMessage());
        }
    }

    @Override
    public void displayMenu() {
        System.out.println("\n========== GYM MANAGEMENT ==========");
        System.out.println("1. Member Management");
        System.out.println("2. Trainer Management");
        System.out.println("3. Workout Session Management");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    @Override
    public void run() {
        boolean running = true;

        while (running) {
            displayMenu();
            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> memberMenu();
                    case 2 -> trainerMenu();
                    case 3 -> sessionMenu();
                    case 0 -> running = false;
                    default -> System.out.println("Invalid choice!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
        scanner.close();
    }

    private void memberMenu() {
        System.out.println("\n------ MEMBER MENU ------");
        System.out.println("1. View All Members");
        System.out.println("2. Demonstrate Polymorphism");
        System.out.print("Enter choice: ");

        try {
            int c = Integer.parseInt(scanner.nextLine());

            switch (c) {
                case 1 -> members.forEach(System.out::println);
                case 2 -> members.forEach(Member::workout);
                default -> System.out.println("Invalid option.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
        }
    }

    private void trainerMenu() {
        System.out.println("\n------ TRAINER MENU ------");
        System.out.println("1. View All Trainers");
        System.out.println("2. Demonstrate Polymorphism");
        System.out.print("Enter choice: ");

        try {
            int c = Integer.parseInt(scanner.nextLine());

            switch (c) {
                case 1 -> trainers.forEach(System.out::println);
                case 2 -> trainers.forEach(Trainer::conductSession);
                default -> System.out.println("Invalid option.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
        }
    }

    private void sessionMenu() {
        System.out.println("\n------ SESSION MENU ------");
        System.out.println("1. View All Sessions");
        System.out.println("2. Demonstrate Polymorphism");
        System.out.print("Enter choice: ");

        try {
            int c = Integer.parseInt(scanner.nextLine());

            switch (c) {
                case 1 -> sessions.forEach(System.out::println);
                case 2 -> sessions.forEach(WorkoutSession::start);
                default -> System.out.println("Invalid option.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
        }
    }
}