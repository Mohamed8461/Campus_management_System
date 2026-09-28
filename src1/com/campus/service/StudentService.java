package com.campus.service;

import com.campus.model.Student;

public class StudentService {
    public int calculateTotalMarks(Student student) {
        int[] marks = student.getMarks();
        if (marks == null) {
            return 0;
        }

        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    public double calculateAverage(Student student) {
        int[] marks = student.getMarks();
        if (marks == null || marks.length == 0) {
            return 0.0;
        }

        int total = calculateTotalMarks(student);
        return (double) total / marks.length;
    }

    public int findMaximum(Student student) {
        int[] marks = student.getMarks();
        if (marks == null || marks.length == 0) {
            return 0;
        }

        int max = marks[0];
        for (int mark : marks) {
            if (mark > max) {
                max = mark;
            }
        }
        return max;
    }

    public int findMinimum(Student student) {
        int[] marks = student.getMarks();
        if (marks == null || marks.length == 0) {
            return 0;
        }

        int min = marks[0];
        for (int mark : marks) {
            if (mark < min) {
                min = mark;
            }
        }
        return min;
    }

    public char grade(Student student) {
        int[] marks = student.getMarks();
        if (marks == null || marks.length == 0) {
            return 'F';
        }

        int average = (int) calculateAverage(student);
        if (average >= 90) {
            return 'A';
        } else if (average >= 80) {
            return 'B';
        } else if (average >= 70) {
            return 'C';
        } else if (average >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public String passorFail(Student student) {
        int[] marks = student.getMarks();
        if (marks == null || marks.length == 0) {
            return "Fail";
        }

        int average = (int) calculateAverage(student);
        if (average >= 50) {
            return "Pass";
        } else {
            return "Fail";
        }
    }

    public void displayReportCard(Student student) {
        System.out.println("Student ID: " + student.getStudentid());
        System.out.println("Student Name: " + student.getStudentname());
        System.out.println("Department: " + student.getDepartment());
        System.out.println("Total Marks: " + calculateTotalMarks(student));
        System.out.println("Average Marks: " + calculateAverage(student));
        System.out.println("Maximum Marks: " + findMaximum(student));
        System.out.println("Minimum Marks: " + findMinimum(student));
        System.out.println("Grade: " + grade(student));
        System.out.println("Result: " + passorFail(student));
    }
}
