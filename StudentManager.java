import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();
    private Scanner input = new Scanner(System.in);

    public void addStudent() {
        try {
            System.out.println("Enter ID");
            int id = input.nextInt();
            input.nextLine();
            System.out.println("Enter Name");
            String name = input.nextLine();
            // input.nextLine();1

            System.out.println("Enter Grade");
            String grade = input.nextLine().toUpperCase();
            if (!grade.matches("[ABCDF]")) {
                throw new InvalidGradeException("The Grade is Invalid");
            }
            students.add(new Student(id, name, grade));
            System.out.println("Student Added");
        } catch (InputMismatchException e) {
            System.out.println("Invalid ID.. Please enter a valid");
            input.nextLine();
        } catch (InvalidGradeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No Students found");
            return;
        }
        for (Student student : students) {
            System.out.println(student);

        }
    }

    public void searchStudent() {
        try {
            System.out.println("Enter the ID to be searched");
            int id = input.nextInt();
            boolean found = false;

            for (Student student : students) {
                if (student.getId() == id) {
                    System.out.println("Student found:" + student);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Not found ID");
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid ID!Please enter a number");
            input.nextLine();

        }

    }

    // save students to a file
    public void saveToFile() {
        try (FileWriter writer = new FileWriter("students.txt")) {
            for (Student student : students) {
                writer.write("ID:" + student.getId() + " " + "Name:" + student.getName() +
                        " Grade:" + student.getGrade() + "\n");
            }
            System.out.println("Data saved to students.txt");
        } catch (IOException e) {
            System.out.println("Error saving file" + e.getMessage());

        }

    }

}
