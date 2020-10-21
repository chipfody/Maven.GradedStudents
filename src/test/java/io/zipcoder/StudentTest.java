package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class StudentTest {


    //given
    String testFirstName = "John";
    String testLastName = "Smith";
    List<Double> testScores = new ArrayList<> (Arrays.asList(100.0, 97.6, 87.4, 82.4));
    Student testStudent = new Student(testFirstName, testLastName, testScores);

    String testFirstName2 = "Steve";
    String testLastName2 = "Blake";
    List<Double> testScores2 = new ArrayList<>();
    Student testStudent2 = new Student(testFirstName2, testLastName2, testScores2);

    @Test
    public void testStudentConstructor() {

        //when
        int testNumberOfExams = 4;

        //then
        Assert.assertEquals(testFirstName, testStudent.getFirstName());
        Assert.assertEquals(testLastName, testStudent.getLastName());
        Assert.assertEquals(testNumberOfExams, testStudent.getNumberOfExamsTaken(testLastName, testFirstName));
    }

    @Test
    public void testGetExamScores() {
        //when
        String expectedOutput = "Exam Scores:\n    Exam 1 -> 100\n    Exam 2 -> 98\n    Exam 3 -> 87\n    Exam 4 -> 82\n";
        String actualOutput = testStudent.getExamScores();
        System.out.println(actualOutput);

        //then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testAddExamScore() {
        //when
        String expectedOutput = "Exam 1 -> 81\n";
        testStudent2.addExamScore(80.8);

        //then
        Assert.assertEquals(expectedOutput, testStudent2.getExamScores());
    }

    @Test
    public void testSetExamScore() {
        //when
        Double newExamScore = 79.4;
        int replaceExamNumber =3;
        String expectedOutput = "Exam 1 -> 100\nExam 2 -> 98\nExam 3 -> 79\nExam 4 -> 82\n";
        testStudent.setExamScore(replaceExamNumber, newExamScore);
        String actualOutput = testStudent.getExamScores();

        //then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testGetAverageExamScore() {
        //when
        int expectedAverage = 92;
        int actualAverage = testStudent.getAverageExamScore();

        //then
        Assert.assertEquals(expectedAverage, actualAverage);
    }
    @Test
    public void testToString() {
        //when
        String expectedOutput = "Student Name: John Smith\nAverage Score: 92\nExam Scores:\n    Exam 1 -> 100\n    Exam 2 -> 98\n    Exam 3 -> 87\n    Exam 4 -> 82\n";

        //then
        Assert.assertEquals(expectedOutput, testStudent.toString());
    }
}