package ru.netology.javacore;

import java.util.*;
import java.util.stream.Collectors;

public class Todos {
    private List<String> tasks;

    public Todos() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(String task) {
        if (tasks.size() < 7) {
            tasks.add(task);
        }
    }

    public void removeTask(String task) {
        tasks.remove(task);
    }

    public String getAllTasks() {
        return tasks.stream().sorted(Comparator.naturalOrder()).collect(Collectors.joining(" "));
    }
}
