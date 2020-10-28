package io.zipcoder;

import java.util.*;

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
        CompareStudents compareStudents = new CompareStudents();        //instantiate an new instance of the comparator we created
        Arrays.sort(students, compareStudents);

        return students;
    }

    class CompareStudents implements Comparator<Student>{               //create an inner class comparator
        public int compare(Student s1, Student s2) {
        if (s1.getAverageExamScore() == s2.getAverageExamScore()) {     //if both have the same average, do a simple compare to list alphabetically
            return (s1.getLastName()).compareTo(s2.getLastName());
        } else {
            return s2.getAverageExamScore() - s1.getAverageExamScore();
            }
        }
    }

    public  Map<Character, ArrayList<Student>> getGradeBook(Student[] students) {

//        ArrayList<Student> aList = new ArrayList<>();
//        ArrayList<Student> bList = new ArrayList<>();
//        ArrayList<Student> cList = new ArrayList<>();
//        ArrayList<Student> dList = new ArrayList<>();
//        ArrayList<Student> fList = new ArrayList<>();

        final Map <Character, ArrayList<Student>> gradeBook = new HashMap<>();
//            gradeBook.put('A', aList);
//            gradeBook.put('B', bList);
//            gradeBook.put('C', cList);
//            gradeBook.put('D', dList);
//            gradeBook.put('F', fList);


            for (int i = 0; i < students.length; i++) {
                char studentGrade = setGrade(students[i], students);
                if (gradeBook.get(studentGrade) == null) {
                    ArrayList<Student> gradeList = new ArrayList<>();
                    gradeList.add(students[i]);
                    gradeBook.put(studentGrade, gradeList);
                } else {
                    gradeBook.get(studentGrade).add(students[i]);


                }
            }


        return gradeBook;

//        HashMap<String, ArrayList<Item>> items = new HashMap<String, ArrayList<Item>>();
//
//        public synchronized void addToList(String mapKey, Item myItem) {
//            List<Item> itemsList = items.get(mapKey);

            // if list does not exist create it

//        if(itemsList == null) {
//            itemsList = new ArrayList<Item>();
//            itemsList.add(myItem);
//            items.put(mapKey, itemsList);
//        } else {
//            // add if item is not already in list
//            if(!itemsList.contains(myItem)) itemsList.add(myItem);
//        }
    }

    public char setGrade(Student student, Student[] students) {

        int classSize = students.length;
        ArrayList<Integer> classGrades = new ArrayList<>();
        char grade = ' ';
        int studentAverage = student.getAverageExamScore();

        for (int i = 0; i < classSize; i++) {
            classGrades.add(students[i].getAverageExamScore());
        }
        Collections.sort(classGrades);

        if (classGrades.indexOf(studentAverage) < (classSize * .10))
            grade = 'F';
        if ((classGrades.indexOf(studentAverage) >= (classSize * .10)) && (classGrades.indexOf(studentAverage) < (classSize * .50)))
            grade = 'D';
        if ((classGrades.indexOf(studentAverage) >= (classSize * .50)) && (classGrades.indexOf(studentAverage) <= (classSize * .70)))
            grade = 'C';
        if ((classGrades.indexOf(studentAverage) > (classSize * .70)) && (classGrades.indexOf(studentAverage) < (classSize * .90)))
            grade =  'B';
        if (classGrades.indexOf(studentAverage) >= (classSize * .90))
            grade = 'A';

//        System.out.println("class grades: " + classGrades);
        System.out.println(studentAverage);
        System.out.println("index = " + classGrades.indexOf(student.getAverageExamScore()));
        return grade;
    }


}

