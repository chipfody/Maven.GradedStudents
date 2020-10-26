package io.zipcoder;

import java.util.List;

public class Student {

    private String firstName;
    private String lastName;
    private final List<Double> examScores;

    public Student(String firstName, String lastName, List<Double> examScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = examScores;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Double> getExamScores() {
        return examScores;
    }

    public String listExamScores() {
        String examScoreList = "Exam Scores:\n";
        for (int i = 0; i < examScores.size(); i++) {
            examScoreList += "    Exam " + (i + 1) + " -> " + Math.round(examScores.get(i)) + "\n";
        }
        return examScoreList;
    }

    public int getNumberOfExamsTaken(String lastName, String firstName){
        return examScores.size();
    }

    public void addExamScore(Double examScore) {
        examScores.add(examScore);
    }

    public void setExamScore(int examNumber, Double newScore) {
        examScores.set(examNumber - 1, newScore);
    }

    public int getAverageExamScore() {
        Double sum = 0.0;
        for (Double score : examScores) {
            sum += score;
        }
        return (int) Math.round(sum / examScores.size());
    }


    @Override
    public String toString() {
        return "Student Name: " + firstName + " " + lastName + "\n" +
                "Average Score: " + getAverageExamScore() +"\n" + listExamScores();
                 }
}
