package studenttracker;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GradeManager {

    private List<Student> students;

    public GradeManager(){
        students= new ArrayList<>();

    }
    public void addStudent(Student student) {
        students.add(student);
    }

    public void printAllStudents() {
        if (students.isEmpty()) {
            System.out.println("📭 No students found.");
            return;
        }
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public void saveToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Student s : students) {
                writer.print(s.getName());
                for (int g : s.getGrades()) {
                    writer.print("," + g);
                }
                writer.println();
            }
            System.out.println("✅ Data saved to " + filename);
        } catch (IOException e) {
            System.out.println("❌ Error saving data: " + e.getMessage());
        }
    }

    public void loadFromFile(String filename) {
        students.clear(); // reset list before loading
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    Student student = new Student(parts[0]);
                    for (int i = 1; i < parts.length; i++) {
                        student.addGrades(Integer.parseInt(parts[i]));
                    }
                    students.add(student);
                }
            }
            System.out.println("📂 Data loaded from " + filename);
        } catch (IOException e) {
            System.out.println("❌ Error loading data: " + e.getMessage());
        }
    }
}
