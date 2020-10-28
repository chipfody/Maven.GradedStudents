package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClassroomTest {

    //given
    String testFirstName = "John";
    String testLastName = "Smith";
    List<Double> testScores = new ArrayList<>(Arrays.asList(100.0, 97.6, 87.4, 82.4));
    Student testStudent = new Student(testFirstName, testLastName, testScores);

    String testFirstName2 = "Steve";
    String testLastName2 = "Blake";
    List<Double> testScores2 = new ArrayList<>(Arrays.asList(74.5, 81.0, 83.8));
    Student testStudent2 = new Student(testFirstName2, testLastName2, testScores2);

    String testFirstName3 = "Mary";
    String testLastName3 = "HaddaLamb";
    List<Double> testScores3 = new ArrayList<>(Arrays.asList(99.8, 89.1));
    Student testStudent3 = new Student(testFirstName3, testLastName3, testScores3);

    String testFirstName4 = "Dianna";
    String testLastName4 = "Prince";
    List<Double> testScores4 = new ArrayList<>(Arrays.asList(90.0, 70.0));
    Student testStudent4 = new Student(testFirstName4, testLastName4, testScores4);

    String testFirstName5 = "Ringo";
    String testLastName5 = "Starr";
    List<Double> testScores5 = new ArrayList<>(Arrays.asList(10.0, 30.0, 45.0));
    Student testStudent5 = new Student(testFirstName5, testLastName5, testScores5);

    String testFirstName6 = "Thorin";
    String testLastName6 = "Oakenshield";
    List<Double> testScores6 = new ArrayList<>(Arrays.asList());
    Student testStudent6 = new Student(testFirstName6, testLastName6, testScores6);

    String testFirstName7 = "Carl";
    String testLastName7 = "Sagan";
    List<Double> testScores7 = new ArrayList<>(Arrays.asList(100.0, 100.0, 100.0, 100.0, 100.0));
    Student testStudent7 = new Student(testFirstName7, testLastName7, testScores7);

    String testFirstName8 = "Ido";
    String testLastName8 = "Poorly";
    List<Double> testScores8 = new ArrayList<>(Arrays.asList(35.0, 42.8, 27.9));
    Student testStudent8 = new Student(testFirstName8, testLastName8, testScores8);

    String testFirstName9 = "Roseann";
    String testLastName9 = "Barr";
    List<Double> testScores9 = new ArrayList<>(Arrays.asList(55.0, 61.2, 57.9, 48.7, 39.7));
    Student testStudent9 = new Student(testFirstName9, testLastName9, testScores9);

    String testFirstName10 = "Popey";
    String testLastName10 = "DaSailor";
    List<Double> testScores10 = new ArrayList<>(Arrays.asList(69.9, 71.3, 65.0, 72.6));
    Student testStudent10 = new Student(testFirstName10, testLastName10, testScores10);






    @Test
    public void testNullaryConstructor() {
        //Given
        Classroom testClassroom = new Classroom();

        //when
        int expectedClassSize = 30;

        //then
        Assert.assertEquals(expectedClassSize, testClassroom.getStudents().length);
    }

    @Test
    public void testSetClassSizeConstructor() {
        //Given
        Classroom testClassroom2 = new Classroom(27);

        //when
        int expectedClassSize2 = 27;

        //then
        Assert.assertEquals(expectedClassSize2, testClassroom2.getStudents().length);
    }

    @Test
    public void testStudentConstructor() {
        //Given
        Student[] students = new Student[2];
        students[0] = testStudent;
        students[1] = testStudent2;
        Classroom testClassroom3 = new Classroom(students);

        //when
        int expectedClassSize3 = 2;

        //then
        Assert.assertEquals(expectedClassSize3, testClassroom3.getStudents().length);
    }

    @Test
    public void testStudentSummary() {

        Classroom testClassroom = new Classroom();
        //when
        int totalScoreExpected = 366;
        int totalExamsExpected = 4;
        int[] returnedScoringData = testClassroom.studentSummary(testStudent);
        int actualScoreTotal = returnedScoringData[0];
        int actualTotalExams = returnedScoringData[1];

        System.out.println(actualScoreTotal + " " + actualTotalExams);

        //then
        Assert.assertEquals(totalScoreExpected, actualScoreTotal);
        Assert.assertEquals(totalExamsExpected, actualTotalExams);
        }

    @Test
    public void testClassAverageScore() {
        //Given
        Student[] students = new Student[2];
        students[0] = testStudent;
        students[1] = testStudent2;
        Classroom testClassroom = new Classroom(students);

        //when
        int expectedClassAverage = 86;

        //then
        Assert.assertEquals(expectedClassAverage, testClassroom.getClassAverage());
    }

    @Test
    public void testClassAverageScore2() {
        //Given
        Student [] students2 = new Student[0];
        Classroom testClassroom2 = new Classroom(students2);

        //when
        int expectedClassAverage2 = 0;

        //then
        Assert.assertEquals(expectedClassAverage2, testClassroom2.getClassAverage());
    }

    @Test
    public void testAddStudent() {
        //Given
        Student[] students = new Student[5];
        students[0] = testStudent;
        students[1] = testStudent2;
        Classroom testClassroom = new Classroom(students);

        //when
        int expectedClassSize = 3;
        int classCount = 0;
        testClassroom.addStudent(testStudent3);
        for (Student student : students) {
            if (student != null)
                classCount++;
        }
        //then
        Assert.assertEquals(expectedClassSize, classCount);
    }

    @Test
    public void testRemoveStudent() {
        //Given
        Student[] students = new Student[5];
        students[0] = testStudent;
        students[1] = testStudent2;
        students[2] = testStudent3;
        Classroom testClassroom = new Classroom(students);

        //when
        int expectedClassSize = 2;
        int classCount = 0;
        testClassroom.removeStudent("Steve", "Blake");
        for (Student student : students) {
            if (student != null)
                classCount++;
        }

        //then
        Assert.assertEquals(expectedClassSize, classCount);
    }

    @Test
    public void testRemoveStudent2() {
        //Given
        Student[] students = new Student[3];  // will throw a null pointer exception error if array size > number of students in class!
        students[0] = testStudent;
        students[1] = testStudent2;
        students[2] = testStudent3;
        Classroom testClassroom = new Classroom(students);

        //when2
        int expectedClassSize2 = 3;
        int classCount2 = 0;
        testClassroom.removeStudent("Mary", "Blake");
        for (Student student : students) {
            if (student != null)
                classCount2++;
        }

        //then
        Assert.assertEquals(expectedClassSize2, classCount2 );
    }

    @Test
    public void testGetStudentByScore() {
        //Given
        Student[] students = new Student[10];  // will throw a null pointer exception error if array size > number of students in class!
        students[0] = testStudent;
        students[1] = testStudent2;
        students[2] = testStudent3;
        students[3] = testStudent4;
        students[4] = testStudent5;
        students[5] = testStudent6;
        students[6] = testStudent7;
        students[7] = testStudent8;
        students[8] = testStudent9;
        students[9] = testStudent10;
        Classroom testClassroom = new Classroom(students);

        //when
        Student[] expectedOrder = new Student[] {testStudent7, testStudent3, testStudent, testStudent2, testStudent4, testStudent10, testStudent9, testStudent8, testStudent5, testStudent6};
        Student[] actual = new Student[10];
        actual = testClassroom.getStudentByScore(students);
        System.out.println(Arrays.toString(actual));

        //then
        Assert.assertArrayEquals(expectedOrder, actual);
    }

    @Test
    public void testSetGradebook() {
        //Given
        Student[] students = new Student[10];  // will throw a null pointer exception error if array size > number of students in class!
        students[0] = testStudent;
        students[1] = testStudent2;
        students[2] = testStudent3;
        students[3] = testStudent4;
        students[4] = testStudent5;
        students[5] = testStudent6;
        students[6] = testStudent7;
        students[7] = testStudent8;
        students[8] = testStudent9;
        students[9] = testStudent10;
        Classroom testClassroom = new Classroom(students);

        //when
        char actualGrade = testClassroom.setGrade(testStudent, students);
        char actualGrade2 = testClassroom.setGrade(testStudent2, students);
        char actualGrade3 = testClassroom.setGrade(testStudent3, students);
        char actualGrade4 = testClassroom.setGrade(testStudent4, students);
        char actualGrade5 = testClassroom.setGrade(testStudent5, students);
        char actualGrade6 = testClassroom.setGrade(testStudent6, students);
        char actualGrade7 = testClassroom.setGrade(testStudent7, students);
        char actualGrade8 = testClassroom.setGrade(testStudent8, students);
        char actualGrade9 = testClassroom.setGrade(testStudent9, students);
        char actualGrade10 = testClassroom.setGrade(testStudent10, students);

        //then

       Assert.assertEquals('B', actualGrade);
//        Assert.assertEquals('C', actualGrade2);
//        Assert.assertEquals('B', actualGrade3);
//        Assert.assertEquals('C', actualGrade4);
//        Assert.assertEquals('D', actualGrade5);
//        Assert.assertEquals('F', actualGrade6);
//        Assert.assertEquals('A', actualGrade7);
//        Assert.assertEquals('D', actualGrade8);
//        Assert.assertEquals('D', actualGrade9);
//        Assert.assertEquals('D', actualGrade10);

    }

}
