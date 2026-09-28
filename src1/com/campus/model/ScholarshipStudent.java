package com.campus.model;

public class ScholarshipStudent extends Student {
    private double scholarshipPercentage;

    public ScholarshipStudent(String studentid, String studentname, int age, String department, int[] marks, double scholarshipPercentage) {
        super(studentid, studentname, age, department, marks);
        this.scholarshipPercentage = scholarshipPercentage;
    }

    public double getScholarshipPercentage() {
        return scholarshipPercentage;
    }

    public void setScholarshippercentage(double scholarshipPercentage) {
        this.scholarshipPercentage = scholarshipPercentage;
    }

    @Override
    public void studentType() {
        System.out.println("Scholarship Student");
    }

    @Override
    public void displayStudentInfo() {
        super.displayStudentInfo();
        System.out.println("Scholarship Percentage: " + scholarshipPercentage);
    }

    @Override
    public void generateReport() {
        System.out.println("Scholarship Student Report Card");
    }

    @Override
    public void eligibleForScholarship() {
        System.out.println("Eligible For Scholarship");
    }
}
