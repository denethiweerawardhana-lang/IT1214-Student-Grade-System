import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.util.System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n=== Student Grade Management System ===");
            System.out.println("1. Add a Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search for a Student by ID");
            System.out.println("4. Calculate and Display Average Mark");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Please enter a number (1-5): ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayAllStudents();
                    break;
                case 3:
                    searchStudentById();
                    break;
                case 4:
                    calculateAverage();
                    break;
                case 5:
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please select between 1 and 5.");
            }
        } while (choice != 5);
    }

  
    private static void addStudent() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine().trim();
        
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine().trim();
        
        System.out.print("Enter Marks: ");
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid marks. Please enter a valid number: ");
            scanner.next();
        }
        double marks = scanner.nextDouble();
        
        studentList.add(new Student(id, name, marks));
        System.out.println("Student record added successfully!");
    }

  
    private static void displayAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }
        System.out.println("\n--- Student Records ---");
        for (Student student : studentList) {
            student.displayStudentDetails();
        }
    }

   
    private static void searchStudentById() {
        if (studentList.isEmpty()) {
            System.out.println("No student records available to search.");
            return;
        }
        System.out.print("Enter Student ID to search: ");
        String searchId = scanner.nextLine().trim();
        boolean found = false;

        for (Student student : studentList) {
            if (student.getStudentId().equalsIgnoreCase(searchId)) {
                System.out.println("\nStudent Found:");
                student.displayStudentDetails();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with ID " + searchId + " not found.");
        }
    }

  
    private static void calculateAverage() {
        if (studentList.isEmpty()) {
            System.out.println("No student records available to calculate average.");
            return;
        }
        double total = 0;
        for (Student student : studentList) {
            total += student.getMarks();
        }
        double average = total / studentList.size();
        System.out.printf("\nTotal Students: %d | Average Mark: %.2f\n", studentList.size(), average);
    }
}





