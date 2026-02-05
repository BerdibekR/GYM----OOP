package com.berdibek.gym.menu;

import com.berdibek.gym.database.MemberDAO;
import com.berdibek.gym.model.Member;
import com.berdibek.gym.model.StudentMember;

import java.util.List;
import java.util.Scanner;

public class MenuManager implements Menu {

    private Scanner scanner = new Scanner(System.in);
    private MemberDAO memberDAO = new MemberDAO();

    @Override
    public void displayMenu() {

        System.out.println("\n===== MEMBER MANAGEMENT =====");
        System.out.println("1. Add Member");
        System.out.println("2. View All Members");
        System.out.println("3. View Student Members Only");
        System.out.println("4. View Premium Members Only");
        System.out.println("5. Update Member");
        System.out.println("6. Delete Member");
        System.out.println("7. Search by Name");
        System.out.println("8. Search by Fee Range");
        System.out.println("9. Search by Minimum Fee");
        System.out.println("10. Polymorphism");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    @Override
    public void run() {

        while (true) {

            displayMenu();
            int c = Integer.parseInt(scanner.nextLine());

            switch (c) {
                case 1 -> addMember();
                case 2 -> memberDAO.getAllMembers();
                case 3 -> filterStudent();
                case 4 -> filterPremium();
                case 5 -> updateMember();
                case 6 -> deleteMember();
                case 7 -> searchByName();
                case 8 -> searchByRange();
                case 9 -> searchByMin();
                case 10 -> polymorphismDemo();
                case 0 -> System.exit(0);
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private void addMember() {

        try {
            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Age: ");
            int age = Integer.parseInt(scanner.nextLine());

            System.out.print("Monthly fee: ");
            double fee = Double.parseDouble(scanner.nextLine());

            StudentMember m =
                    new StudentMember(1, name, age, "Student", "AITU");

            m.setMonthlyFee(fee);
            memberDAO.insertMember(m);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void filterStudent() {
        memberDAO.searchByName("")
                .stream()
                .filter(m -> m.getMembershipType().equalsIgnoreCase("Student"))
                .forEach(System.out::println);
    }

    private void filterPremium() {
        memberDAO.searchByName("")
                .stream()
                .filter(m -> m.getMembershipType().equalsIgnoreCase("Premium"))
                .forEach(System.out::println);
    }

    private void updateMember() {

        System.out.print("Enter Member ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        Member m = memberDAO.getMemberById(id);
        if (m == null) return;

        System.out.print("New name [" + m.getName() + "]: ");
        String name = scanner.nextLine();

        if (!name.isEmpty()) {
            try {
                m.setName(name);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        memberDAO.updateMember(m);
    }

    private void deleteMember() {

        System.out.print("Enter Member ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        Member m = memberDAO.getMemberById(id);
        if (m == null) return;

        System.out.println(m);
        System.out.print("Confirm delete (yes/no): ");

        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            memberDAO.deleteMember(id);
        }
    }

    private void searchByName() {

        System.out.print("Name: ");
        memberDAO.searchByName(scanner.nextLine())
                .forEach(System.out::println);
    }

    private void searchByRange() {

        System.out.print("Min fee: ");
        double min = Double.parseDouble(scanner.nextLine());

        System.out.print("Max fee: ");
        double max = Double.parseDouble(scanner.nextLine());

        memberDAO.searchByFeeRange(min, max)
                .forEach(System.out::println);
    }

    private void searchByMin() {

        System.out.print("Minimum fee: ");
        double min = Double.parseDouble(scanner.nextLine());

        memberDAO.searchByMinFee(min)
                .forEach(System.out::println);
    }

    private void polymorphismDemo() {

        List<Member> list = memberDAO.searchByName("");

        for (Member m : list) {
            m.workout();
        }
    }
}