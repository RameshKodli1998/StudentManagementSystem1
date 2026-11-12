package StudentManagement;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = FileHandler.loadStudents();
        StudentManagement management = new StudentManagement(students);

        while (true) {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");

            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id;

                    try {
                        id = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid ID number.");
                        break;
                    }

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Age: ");
                    int age;

                    try {
                        age = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid age.");
                        break;
                    }

                    System.out.print("Enter Course: ");
                    String course = scanner.nextLine();

                    management.addStudent(new Student(id, name, age, course));
                    break;

                case 2:
                    management.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter Student ID to update: ");
                    int updateId;

                    try {
                        updateId = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid Student ID.");
                        break;
                    }
                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();

                    System.out.print("Enter New Age: ");
                    int newAge = Integer.parseInt(scanner.nextLine());

                    System.out.print("Enter New Course: ");
                    String newCourse = scanner.nextLine();

                    management.updateStudent(updateId, newName, newAge, newCourse);
                    break;

                case 4:
                    System.out.print("Enter Student ID to delete: ");
                    int deleteId;

                    try {
                        deleteId = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid Student ID.");
                        break;
                    }
                case 5:
                    scanner.close();
                    System.out.println("Thank you!");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}