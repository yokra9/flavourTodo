package com.example;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.teavm.flavour.templates.BindTemplate;
import org.teavm.flavour.templates.Templates;

@BindTemplate("templates/client.html")
public class Client {
    private List<Todo> todos = new ArrayList<>();
    private String newTodoText = "";
    private boolean hideCompleted;

    public static void main(String[] args) {
        Locale.setDefault(Locale.JAPANESE);
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Tokyo"));
        Templates.bind(new Client(), "application-content");
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public String getNewTodoText() {
        return newTodoText;
    }

    public void setNewTodoText(String newTodoText) {
        this.newTodoText = newTodoText;
    }

    public void addTodo() {
        if (newTodoText != null && !newTodoText.trim().isEmpty()) {
            todos.add(new Todo(newTodoText));
            newTodoText = "";
        }
    }

    public void deleteTodo(Todo todo) {
        todos.remove(todo);
    }

    public boolean isHideCompleted() {
        return hideCompleted;
    }

    public void setHideCompleted(boolean hideCompleted) {
        this.hideCompleted = hideCompleted;
    }

    public List<Todo> getVisibleTodos() {
        if (!hideCompleted) {
            return todos;
        }
        List<Todo> visibleTodos = new ArrayList<>();
        for (Todo todo : todos) {
            if (!todo.isCompleted()) {
                visibleTodos.add(todo);
            }
        }
        return visibleTodos;
    }

    public int getActiveCount() {
        int count = 0;
        for (Todo todo : todos) {
            if (!todo.isCompleted()) {
                count++;
            }
        }
        return count;
    }

    public boolean isHasCompletedItems() {
        for (Todo todo : todos) {
            if (todo.isCompleted()) {
                return true;
            }
        }
        return false;
    }

    public void clearCompleted() {
        todos.removeIf(Todo::isCompleted);
    }

    public String formatDate(Date date) {
        if (date == null) return "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm", Locale.getDefault());
        sdf.setTimeZone(TimeZone.getDefault());
        return sdf.format(date);
    }
}