package ru.netology.javacore;

import org.junit.jupiter.api.Assertions;

public class TodosTests {
    Todos todos = new Todos();

    @org.junit.jupiter.api.Test
    public void testGetAllTasks() {
        todos.addTask("задача 1");
        Assertions.assertEquals("задача 1", todos.getAllTasks());
    }

    @org.junit.jupiter.api.Test
    public void testAddTask() {
        todos.addTask("задача 1");
        todos.addTask("задача 2");
        Assertions.assertEquals("задача 1 задача 2", todos.getAllTasks());
    }

    @org.junit.jupiter.api.Test
    public void testRemoveTask() {
        todos.addTask("задача 1");
        todos.removeTask("задача 1");
        Assertions.assertEquals("", todos.getAllTasks());
    }
}
