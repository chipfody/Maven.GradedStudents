package io.zipcoder;

import java.util.Arrays;
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
        int scoreSummary = 0;
        int numberOfTests = 0;
        for (int i = 0; i < students.length; i++) {
            scoreSummary += studentSummary(students[i])[0];
            numberOfTests += studentSummary(students[i])[1];
        }
        if (numberOfTests == 0) {
            return 0;
        }else {
            return (int) scoreSummary / numberOfTests;
        }
    }
    public int[] studentSummary(Student student) {
        int[] studentTotals = new int[2];
        int examTotals = 0;
        int totalExams = 0;
        for (int i = 0; i < student.getExamScores().size(); i++) {
            examTotals += student.getExamScores().get(i);
            totalExams++;
        }
        studentTotals[0] = examTotals;
        studentTotals[1] = totalExams;

        return studentTotals;
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
        CompareStudents compareStudents = new CompareStudents();
        Arrays.sort(students, compareStudents);

        return students;
    }
    class CompareStudents implements Comparator<Student>{
        public int compare(Student s1, Student s2) {
        if (s1.getAverageExamScore() == s2.getAverageExamScore()) {
            return (s1.getLastName()).compareTo(s2.getLastName());
        } else {
            return s2.getAverageExamScore() - s1.getAverageExamScore();
        }
    }
    }

}

