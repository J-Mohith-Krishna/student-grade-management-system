import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GradeManagementSystem {
    private static Map<String, Double> studentGrades = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean quit = false;

        while (!quit) {
            System.out.println("\n1. Add Student Grade");
            System.out.println("2. Remove Student Grade");
            System.out.println("3. View Student Grades");
            System.out.println("4. Calculate Average Grade");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudentGrade();
                    break;
                case 2:
                    removeStudentGrade();
                    break;
                case 3:
                    viewStudentGrades();
                    break;
                case 4:
                    calculateAverageGrade();
                    break;
                case 5:
                    quit = true;
                    System.out.println("Thank you for using the Grade Management System!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addStudentGrade() {
        System.out.print("Enter student name: ");
        scanner.nextLine(); // Consume newline
        String name = scanner.nextLine();
        System.out.print("Enter student grade: ");
        double grade = scanner.nextDouble();
        studentGrades.put(name, grade);
        System.out.println("Grade added successfully.");
    }

    private static void removeStudentGrade() {
        if (studentGrades.isEmpty()) {
            System.out.println("No student grades to remove.");
        } else {
            System.out.println("Student Grades:");
            for (String name : studentGrades.keySet()) {
                System.out.println(name + ": " + studentGrades.get(name));
            }
            System.out.print("Enter the name of the student to remove: ");
            scanner.nextLine(); // Consume newline
            String nameToRemove = scanner.nextLine();
            if (studentGrades.containsKey(nameToRemove)) {
                studentGrades.remove(nameToRemove);
                System.out.println("Student grade removed successfully.");
            } else {
                System.out.println("Student not found.");
            }
        }
    }

    private static void viewStudentGrades() {
        if (studentGrades.isEmpty()) {
            System.out.println("No student grades available.");
        } else {
            System.out.println("Student Grades:");
            for (String name : studentGrades.keySet()) {
                System.out.println(name + ": " + studentGrades.get(name));
            }
        }
    }

    private static void calculateAverageGrade() {
        if (studentGrades.isEmpty()) {
            System.out.println("No student grades available.");
        } else {
            double sum = 0;
            for (double grade : studentGrades.values()) {
                sum += grade;
            }
            double average = sum / studentGrades.size();
            System.out.println("Average grade: " + average);
        }
    }
}
