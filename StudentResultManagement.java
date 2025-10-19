import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Student {
    String name;
    int marks1, marks2, marks3;
    int total;
    double average;
    char grade;

    void inputDetails(Scanner sc) {
        System.out.print("Enter Student Name: ");
        name = sc.nextLine();

        System.out.print("Enter marks in Subject 1: ");
        marks1 = sc.nextInt();

        System.out.print("Enter marks in Subject 2: ");
        marks2 = sc.nextInt();

        System.out.print("Enter marks in Subject 3: ");
        marks3 = sc.nextInt();
        sc.nextLine(); // consume newline
    }

    void calculateResults() {
        total = marks1 + marks2 + marks3;
        average = total / 3.0;

        if (average >= 90)
            grade = 'A';
        else if (average >= 75)
            grade = 'B';
        else if (average >= 60)
            grade = 'C';
        else if (average >= 40)
            grade = 'D';
        else
            grade = 'F';
    }

    void display() {
        System.out.printf("%-10s %-8d %-8d %-8d %-8d %-10.2f %-5c\n",
                name, marks1, marks2, marks3, total, average, grade);
    }

    String toFileString() {
        return String.format("%-10s %-8d %-8d %-8d %-8d %-10.2f %-5c\n",
                name, marks1, marks2, marks3, total, average, grade);
    }
}

public class StudentResultManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Advanced Student Result Management System ===");

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        Student[] students = new Student[n];

        // Input student data
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Student " + (i + 1) + ":");
            students[i] = new Student();
            students[i].inputDetails(sc);
            students[i].calculateResults();
        }

        // Sort students by average (descending order)
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (students[j].average > students[i].average) {
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }

        // Display report
        System.out.println("\n=== STUDENT REPORT (Sorted by Average Marks) ===");
        System.out.printf("%-10s %-8s %-8s %-8s %-8s %-10s %-5s\n",
                "Name", "Sub1", "Sub2", "Sub3", "Total", "Average", "Grade");
        System.out.println("--------------------------------------------------------------");
        for (Student s : students) {
            s.display();
        }

        // Save report to file
        try (FileWriter fw = new FileWriter("StudentReport.txt")) {
            fw.write("=== STUDENT REPORT (Sorted by Average Marks) ===\n");
            fw.write(String.format("%-10s %-8s %-8s %-8s %-8s %-10s %-5s\n",
                    "Name", "Sub1", "Sub2", "Sub3", "Total", "Average", "Grade"));
            fw.write("--------------------------------------------------------------\n");
            for (Student s : students) {
                fw.write(s.toFileString());
            }
            System.out.println("\n✅ Report saved successfully in 'StudentReport.txt'");
        } catch (IOException e) {
            System.out.println("❌ Error saving file: " + e.getMessage());
        }

        sc.close();
    }
}
