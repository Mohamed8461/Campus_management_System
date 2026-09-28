package com.campus.model;

import java.util.Arrays;

public abstract class Student {
    private String studentid;
    private String studentname;
    private int age;
    private String department;
    private int[] marks;

    static int studentCount = 0;

    public Student() {
        studentCount++;
    }

    public Student(String studentid, String studentname, int age, String department, int[] marks) {
        this.studentid = studentid;
        this.studentname = studentname;
        this.age = age;
        this.department = department;
        this.marks = marks;
        studentCount++;
    }

    public String getStudentid() {
        return studentid;
    }

    public String getStudentname() {
        return studentname;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public int[] getMarks() {
        return marks;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setMarks(int[] marks) {
        this.marks = marks;
    }

    public void displayStudentInfo() {
        System.out.println("Student ID: " + studentid);
        System.out.println("Student Name: " + studentname);
        System.out.println("Age: " + age);
        System.out.println("Department: " + department);
    }

    public void displayStudentInfo(boolean showMark) {
        displayStudentInfo();
        if (showMark) {
            System.out.println("Marks: " + Arrays.toString(marks));
        }
    }
    //abstract method
    public abstract void studentType();

    public void generateReport() {
        System.out.println("Student report generated.");
    }

    public void eligibleForScholarship() {
        System.out.println("Not eligible for scholarship.");
    }

    public static void displayStudentCount() {
        System.out.println("Total number of students: " + studentCount);
    }
}