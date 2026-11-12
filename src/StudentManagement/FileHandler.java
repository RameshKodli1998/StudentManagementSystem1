package StudentManagement;

import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    private static final String FILE_NAME = "students.dat";

    // Save Students
    public static void saveStudents(ArrayList<Student> students) {
        try (ObjectOutputStream output =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            output.writeObject(students);
            System.out.println("Student records saved successfully!");

        } catch (IOException e) {
            System.out.println("Error saving records: " + e.getMessage());
        }
    }

    // Load Students
    @SuppressWarnings("unchecked")
    public static ArrayList<Student> loadStudents() {
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream input =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            return (ArrayList<Student>) input.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading records: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}