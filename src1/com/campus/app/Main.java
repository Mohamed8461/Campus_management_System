package com.campus.app;

import com.campus.model.ScholarshipStudent;
import com.campus.model.Student;
import com.campus.service.StudentService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter student age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter student department: ");
        String department = scanner.nextLine();

        System.out.print("Enter the number of subjects: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        int[] marks = new int[n];
        System.out.println("Enter the marks of " + n + " subjects");
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the marks of subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
            scanner.nextLine();
        }

        System.out.print("Enter the scholarship percentage: ");
        double scholarshipPercentage = scanner.nextDouble();
        scanner.nextLine();

        Student student = new ScholarshipStudent(id, name, age, department, marks, scholarshipPercentage);
        student.displayStudentInfo(true);
        Student.displayStudentCount();

        StudentService studentService = new StudentService();
        studentService.displayReportCard(student);

        scanner.close();
    }
}
