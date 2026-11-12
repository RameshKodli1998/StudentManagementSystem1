package StudentManagement;

import java.util.ArrayList;

public class StudentManagement {

    private ArrayList<Student> students;

    public StudentManagement(ArrayList<Student> students) {
        this.students = students;
    }
    // Add Students
    public void addStudent(Student student) {

        for (Student existing : students) {
            if (existing.getId() == student.getId()) {
                System.out.println("Student ID already exists!");
                return;
            }
        }

        students.add(student);
        FileHandler.saveStudents(students);
        System.out.println("Student added successfully!");
    }

    // View Students
    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student student : students) {
            System.out.println(student);
        }
    }

    // Update Student
    public void updateStudent(int id, String name, int age, String course) {
        for (Student student : students) {
            if (student.getId() == id) {
                student.setName(name);
                student.setAge(age);
                student.setCourse(course);

                FileHandler.saveStudents(students);
                System.out.println("Student updated successfully!");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    // Delete Student
    public void deleteStudent(int id) {
        boolean removed = students.removeIf(
                student -> student.getId() == id
        );

        if (removed) {
            FileHandler.saveStudents(students);
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }
}