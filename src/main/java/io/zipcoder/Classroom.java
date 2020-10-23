package io.zipcoder;

import java.util.Collections;
import java.util.Comparator;

public class Classroom {

    private Student[] students;

    public Classroom(int classSize) {
        this.students = new Student[classSize];
    }

    public Classroom(Student[] students) {
        this.students = students;
    }

    public Classroom() {
        this.students = new Student[30];
    }


    public Student[] getStudents() {
        return students;
    }

    public int getClassAverage() {
        int classAverage = 0;
        int totalTests = 0;
        for (int i = 0; i < students.length; i++) {
            classAverage += students[i].getAverageExamScore();
        }
        return (int) classAverage / students.length;
    }

    public void addStudent(Student newStudent) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = newStudent;
                break;
            }
        }
    }

    public void removeStudent(String firstName, String lastName) {
        int next = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i].getFirstName() == firstName && students[i].getLastName() == lastName) {
                next = i;
                break;
            }
        }
            if (next == 0) {
                System.out.println("Student not found");
            } else {
                for (int j = next; j < students.length - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[students.length - 1] = null;
            }
    }

    public Student[] getStudentByScore(Student[] students) {
        Student[] resultArray = new Student[students.length];


        return resultArray;
    }
}

