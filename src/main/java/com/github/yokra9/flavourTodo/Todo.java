package com.github.yokra9.flavourTodo;

import java.time.Instant;

public class Todo {
    private String text;
    private boolean completed;
    private Instant creationDate;

    public Todo(String text) {
        this.text = text;
        this.creationDate = Instant.now();
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

    public Instant getCreationDate() {
        return creationDate;
    }
}