package com.github.yokra9.flavourTodo;

import java.util.Date;

public class Todo {
    private String text;
    private boolean completed;
    private Date creationDate;

    public Todo(String text) {
        this.text = text;
        this.creationDate = new Date();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Date getCreationDate() {
        return creationDate;
    }
}