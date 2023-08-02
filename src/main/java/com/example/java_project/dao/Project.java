package com.example.java_project.dao;

public class Project{

    private String name;
    private String description;
    private boolean submitted;
    private boolean evaluated;
    private Feedback feedback;

    public Project(String name, String description, boolean submitted, boolean evaluated) {
        this.name=name;
        this.description=description;
        this.submitted=submitted;
        this.evaluated=evaluated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isSubmitted() {
        return submitted;
    }

    public void setSubmitted(boolean submitted) {
        this.submitted = submitted;
    }

    public boolean isEvaluated() {
        return evaluated;
    }

    public void setEvaluated(boolean evaluated) {
        this.evaluated = evaluated;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }
}
