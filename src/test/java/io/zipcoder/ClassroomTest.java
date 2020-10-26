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



}
