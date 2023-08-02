package com.example.java_project.dao;

public class Feedback {
    private int grade;
    private String comments;
    private String suggestions;

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        if (grade < 0) this.grade=0;
        else if (grade > 20 ) this.grade = 20;
        else this.grade = grade;



    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(String suggestions) {
        this.suggestions = suggestions;
    }


}
