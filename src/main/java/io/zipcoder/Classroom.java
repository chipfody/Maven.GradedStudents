package io.zipcoder;

public class Classroom {

    private Student [] students;

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
        for(int i = 0; i < students.length; i++) {
            classAverage += students[i].getAverageExamScore();
        }
        return (int) classAverage / students.length;
    }

    public void addStudent(Student newStudent) {
        int newStudentPlace = students.length;
        students[newStudentPlace - 1] = newStudent;
    }
}
