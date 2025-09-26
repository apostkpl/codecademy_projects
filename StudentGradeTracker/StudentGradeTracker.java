
// Necessary Imports
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class StudentGradeTracker {
    public static void main(String[] args) {
        // Array initialization
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Double> grades = new ArrayList<>();

        boolean running = true;

        try (Scanner scanner = new Scanner(System.in)) {
            while (running) {
                System.out.println(
                        "1. Add a new student and grade\n2. View all students and their grades\n3. Calculate the class average\n4. Quit the program");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                // Handle the choice of user
                switch (choice) {
                    case 1:
                        // Get the student name
                        System.out.print("Enter Student Full Name: ");
                        String name = scanner.nextLine();
                        // Get the student grade. Do some basic sanity check for the grade's value
                        double grade = 0.0;
                        while (true) {
                            System.out.print("\nEnter Student Grade: ");
                            grade = scanner.nextInt();
                            scanner.nextLine();
                            if (grade >= 0 && grade <= 100) {
                                break;
                            } else {
                                System.out.println("Please enter a valid grade [0-100]");
                            }
                        }
                        names.add(name);
                        grades.add(grade);
                        System.out.printf("Student: %s\nwith grade: %f\nhas been successfully added!\n\n", name, grade);
                        break;
                    case 2:
                        if (names.isEmpty()) {
                            System.out.println("No students yet.");
                        } else {
                            if (names.size() == grades.size()) {
                                for (int i = 0; i < names.size(); i++) {
                                    System.out.printf("Student name: %s, Student grade: %f\n", names.get(i),
                                            grades.get(i));
                                }
                            } else {
                                System.out.println("Length inconsistency between the two lists (names and grades).");
                            }
                        }
                        break;
                    case 3:
                        if (names.isEmpty()) {
                            System.out.println("No students yet.");
                        } else {
                            double average = grades.stream().mapToDouble(num -> num.doubleValue()).average()
                                    .getAsDouble();
                            System.out.printf("The average grade of the students is: %f\n\n", average);
                        }
                        break;
                    case 4:
                        System.out.println("Stopped.");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid number.");
        }
    }
}