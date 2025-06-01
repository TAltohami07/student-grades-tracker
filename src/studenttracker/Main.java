package studenttracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GradeManager manager = new GradeManager();
        String filename = "grades.txt";

        while (true) {
            System.out.println("\n📚 Student Grades Tracker");
            System.out.println("1. Add student");
            System.out.println("2. View all students");
            System.out.println("3. Save to file");
            System.out.println("4. Load from file");
            System.out.println("0. Exit");
            System.out.print("👉 Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("👤 Enter student name: ");
                    String name = scanner.nextLine();
                    Student student = new Student(name);

                    while (true) {
                        System.out.print("➕ Enter grade (or -1 to stop): ");
                        int grade = scanner.nextInt();
                        if (grade == -1) break;
                        student.addGrades(grade);
                    }
                    scanner.nextLine(); // consume newline
                    manager.addStudent(student);
                    break;

                case 2:
                    manager.printAllStudents();
                    break;

                case 3:
                    manager.saveToFile(filename);
                    break;

                case 4:
                    manager.loadFromFile(filename);
                    break;

                case 0:
                    System.out.println("👋 Goodbye!");
                    return;

                default:
                    System.out.println("❌ Invalid choice.");
            }
        }
    }
}
