// Necessary Imports
import java.util.ArrayList;
import Java.util.Scanner;

public class StudentGradeTracker {
    public static void main(String[] args) {
        // Array initialization
        ArrayList<String> names = new ArrayList<>(); 
        ArrayList<Double> grades = new ArrayList<>(); 
        
        boolean running = true;
        while (running) {
            System.out.println("1. Add a new student and grade\n2. View all students and their grades\n3. Calculate the class average\n4. Quit the program");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your choice:");
            int choice = scanner.nextInt();

            // Handle the choice of user
            switch (choice) {
                case 1:
                    // Get the student name
                    System.out.println("Enter Student Full Name: ");
                    String name = scanner.nextLine();
                    // Get the student grade. Do some basic sanity check for the grade's value
                    while (true) {
                        System.out.println("Enter Student Grade: ");
                        double grade = scanner.nextInt();
                        if (grade >= 0 && grade <= 100) {
                            break;
                        } else {
                            System.out.println("Please enter a valid grade [0-100]");
                        }
                    }
                    names.add(name);
                    grades.add(grade);
                    System.out.printf("Student: %s\nwith grade: %f\nhas been successfully added!\n", name, grade);
                    break;
                case 2:
                    if (names.isEmpty()) {
                        System.out.println("No students yet.");
                    }
            }

        }
    }
}