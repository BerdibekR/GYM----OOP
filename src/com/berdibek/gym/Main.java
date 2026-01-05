package com.berdibek.gym;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // POLYMORPHIC LISTS
    private static ArrayList<Member> members = new ArrayList<>();
    private static ArrayList<Trainer> trainers = new ArrayList<>();
    private static ArrayList<WorkoutSession> sessions = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        members.add(new Member(1, "Arman", 23, "Basic"));
        members.add(new StudentMember(2, "Dastan", 19, "Student", "NU"));
        members.add(new PremiumMember(3, "Aibek", 28, "Premium", true));
        members.add(new SeniorMember(4, "Samat", 61, "Senior", 60, 15));

        trainers.add(new Trainer(101, "Bagzhan", "Fitness", 6));
        trainers.add(new PersonalTrainer(102, "Aidar", "Strength", 4, 12));
        trainers.add(new GroupTrainer(103, "Dana", "Yoga", 3, 18));

        sessions.add(new WorkoutSession(1001, "Arman", "Bagzhan", 60, false));
        sessions.add(new CardioSession(1002, "Dastan", "Aidar", 45, true, 380));
        sessions.add(new StrengthSession(1003, "Aibek", "Dana", 70, false, "Chest"));
        sessions.add(new YogaSession(1004, "Aruzhan", "Dana", 50, false, "Intermediate", true));

        boolean running = true;
        while (running) {
            mainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> memberMenu();
                case 2 -> trainerMenu();
                case 3 -> sessionMenu();
                case 0 -> running = false;
                default -> System.out.println("Invalid choice!");
            }

            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
    }

    private static void mainMenu() {
        System.out.println("\n========== GYM MANAGEMENT ==========");
        System.out.println("1. Member Management");
        System.out.println("2. Trainer Management");
        System.out.println("3. Workout Session Management");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    private static void memberMenu() {
        System.out.println("\n------ MEMBER MENU ------");
        System.out.println("1. Add Member");
        System.out.println("2. Add Student Member");
        System.out.println("3. Add Premium Member");
        System.out.println("4. Add Senior Member");
        System.out.println("5. View All Members");
        System.out.println("6. Demonstrate Polymorphism");
        System.out.println("7. View Students Only");
        System.out.println("8. View Premium Only");
        System.out.println("9. View Senior Only");
        System.out.print("Enter choice: ");

        int c = scanner.nextInt();
        scanner.nextLine();

        switch (c) {
            case 1 -> addGeneralMember();
            case 2 -> addStudentMember();
            case 3 -> addPremiumMember();
            case 4 -> addSeniorMember();
            case 5 -> viewAllMembers();
            case 6 -> demonstrateMemberPolymorphism();
            case 7 -> viewMembersByType(StudentMember.class);
            case 8 -> viewMembersByType(PremiumMember.class);
            case 9 -> viewMembersByType(SeniorMember.class);
            default -> System.out.println("Invalid option.");
        }
    }

    private static void addGeneralMember() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt(); scanner.nextLine();
        System.out.print("Type: ");
        String type = scanner.nextLine();

        int id = members.size() + 1;
        members.add(new Member(id, name, age, type));
        System.out.println("General member added!");
    }

    private static void addStudentMember() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt(); scanner.nextLine();
        System.out.print("University: ");
        String uni = scanner.nextLine();

        int id = members.size() + 1;
        members.add(new StudentMember(id, name, age, "Student", uni));
        System.out.println("Student member added!");
    }

    private static void addPremiumMember() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt(); scanner.nextLine();

        int id = members.size() + 1;
        members.add(new PremiumMember(id, name, age, "Premium", true));
        System.out.println("Premium member added!");
    }

    private static void addSeniorMember() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt(); scanner.nextLine();
        System.out.print("Retirement age: ");
        int rAge = scanner.nextInt(); scanner.nextLine();
        System.out.print("Health discount %: ");
        double disc = scanner.nextDouble(); scanner.nextLine();

        int id = members.size() + 1;
        members.add(new SeniorMember(id, name, age, "Senior", rAge, disc));
        System.out.println("Senior member added!");
    }

    private static void viewAllMembers() {
        System.out.println("\n--- ALL MEMBERS ---");
        members.forEach(System.out::println);
    }

    private static void demonstrateMemberPolymorphism() {
        System.out.println("\n--- MEMBER POLYMORPHISM ---");
        for (Member m : members) m.workout();
    }

    private static void viewMembersByType(Class<?> type) {
        System.out.println("\n--- FILTERED MEMBERS: " + type.getSimpleName() + " ---");
        members.stream().filter(type::isInstance).forEach(System.out::println);
    }

    private static void trainerMenu() {
        System.out.println("\n------ TRAINER MENU ------");
        System.out.println("1. Add Trainer");
        System.out.println("2. Add Personal Trainer");
        System.out.println("3. Add Group Trainer");
        System.out.println("4. View All Trainers");
        System.out.println("5. Demonstrate Polymorphism");
        System.out.print("Enter choice: ");

        int c = scanner.nextInt();
        scanner.nextLine();

        switch (c) {
            case 1 -> addGeneralTrainer();
            case 2 -> addPersonalTrainer();
            case 3 -> addGroupTrainer();
            case 4 -> viewAllTrainers();
            case 5 -> demonstrateTrainerPolymorphism();
            default -> System.out.println("Invalid option.");
        }
    }

    private static void addGeneralTrainer() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Specialization: ");
        String spec = scanner.nextLine();
        System.out.print("Experience years: ");
        int exp = scanner.nextInt(); scanner.nextLine();

        int id = trainers.size() + 101;
        trainers.add(new Trainer(id, name, spec, exp));
        System.out.println("Trainer added!");
    }

    private static void addPersonalTrainer() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Specialization: ");
        String spec = scanner.nextLine();
        System.out.print("Experience years: ");
        int exp = scanner.nextInt(); scanner.nextLine();
        System.out.print("Clients count: ");
        int clients = scanner.nextInt(); scanner.nextLine();

        int id = trainers.size() + 101;
        trainers.add(new PersonalTrainer(id, name, spec, exp, clients));
        System.out.println("Personal trainer added!");
    }

    private static void addGroupTrainer() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Specialization: ");
        String spec = scanner.nextLine();
        System.out.print("Experience years: ");
        int exp = scanner.nextInt(); scanner.nextLine();
        System.out.print("Group size: ");
        int size = scanner.nextInt(); scanner.nextLine();

        int id = trainers.size() + 101;
        trainers.add(new GroupTrainer(id, name, spec, exp, size));
        System.out.println("Group trainer added!");
    }

    private static void viewAllTrainers() {
        System.out.println("\n--- ALL TRAINERS ---");
        trainers.forEach(System.out::println);
    }

    private static void demonstrateTrainerPolymorphism() {
        System.out.println("\n--- TRAINER POLYMORPHISM ---");
        for (Trainer t : trainers) t.conductSession();
    }

    private static void sessionMenu() {
        System.out.println("\n------ SESSION MENU ------");
        System.out.println("1. Add General Session");
        System.out.println("2. Add Cardio Session");
        System.out.println("3. Add Strength Session");
        System.out.println("4. Add Yoga Session");
        System.out.println("5. View All Sessions");
        System.out.println("6. Demonstrate Polymorphism");
        System.out.println("7. View Cardio Only");
        System.out.println("8. View Strength Only");
        System.out.println("9. View Yoga Only");
        System.out.print("Enter choice: ");

        int c = scanner.nextInt();
        scanner.nextLine();

        switch (c) {
            case 1 -> addGeneralSession();
            case 2 -> addCardioSession();
            case 3 -> addStrengthSession();
            case 4 -> addYogaSession();
            case 5 -> viewAllSessions();
            case 6 -> demonstrateSessionPolymorphism();
            case 7 -> viewSessionsByType(CardioSession.class);
            case 8 -> viewSessionsByType(StrengthSession.class);
            case 9 -> viewSessionsByType(YogaSession.class);
            default -> System.out.println("Invalid option.");
        }
    }

    private static void addGeneralSession() {
        System.out.print("Member: ");
        String m = scanner.nextLine();
        System.out.print("Trainer: ");
        String t = scanner.nextLine();
        System.out.print("Duration: ");
        int d = scanner.nextInt(); scanner.nextLine();

        int id = sessions.size() + 1001;
        sessions.add(new WorkoutSession(id, m, t, d, false));
        System.out.println("Session added!");
    }

    private static void addCardioSession() {
        System.out.print("Member: ");
        String m = scanner.nextLine();
        System.out.print("Trainer: ");
        String t = scanner.nextLine();
        System.out.print("Duration: ");
        int d = scanner.nextInt(); scanner.nextLine();
        System.out.print("Calories target: ");
        int cals = scanner.nextInt(); scanner.nextLine();

        int id = sessions.size() + 1001;
        sessions.add(new CardioSession(id, m, t, d, false, cals));
        System.out.println("Cardio session added!");
    }

    private static void addStrengthSession() {
        System.out.print("Member: ");
        String m = scanner.nextLine();
        System.out.print("Trainer: ");
        String t = scanner.nextLine();
        System.out.print("Duration: ");
        int d = scanner.nextInt(); scanner.nextLine();
        System.out.print("Muscle group: ");
        String mg = scanner.nextLine();

        int id = sessions.size() + 1001;
        sessions.add(new StrengthSession(id, m, t, d, false, mg));
        System.out.println("Strength session added!");
    }

    private static void addYogaSession() {
        System.out.print("Member: ");
        String m = scanner.nextLine();
        System.out.print("Trainer: ");
        String t = scanner.nextLine();
        System.out.print("Duration: ");
        int d = scanner.nextInt(); scanner.nextLine();
        System.out.print("Difficulty Level: ");
        String level = scanner.nextLine();
        System.out.print("Meditation included? (true/false): ");
        boolean med = scanner.nextBoolean(); scanner.nextLine();

        int id = sessions.size() + 1001;
        sessions.add(new YogaSession(id, m, t, d, false, level, med));
        System.out.println("Yoga session added!");
    }

    private static void viewAllSessions() {
        System.out.println("\n--- ALL SESSIONS ---");
        sessions.forEach(System.out::println);
    }

    private static void demonstrateSessionPolymorphism() {
        System.out.println("\n--- SESSION POLYMORPHISM ---");
        for (WorkoutSession s : sessions) s.start();
    }

    private static void viewSessionsByType(Class<?> type) {
        System.out.println("\n--- FILTERED SESSIONS: " + type.getSimpleName() + " ---");
        sessions.stream().filter(type::isInstance).forEach(System.out::println);
    }
}