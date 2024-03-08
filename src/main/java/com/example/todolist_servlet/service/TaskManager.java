package com.example.todolist_servlet.service;

import com.example.todolist_servlet.beans.Status;
import com.example.todolist_servlet.beans.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private static final TaskManager INSTANCE = new TaskManager();
    private final ArrayList<Task> taskList = new ArrayList<>();

    public static TaskManager getInstance() {
        return INSTANCE;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void addTask(Task task) {
        taskList.add(task);
    }

    public void deleteTask(int taskId) {
        taskList.remove(taskId);
    }

    public void updateTaskStatus(int taskId, Status status) {
        taskList.get(taskId)
                .setStatus(status);
    }
}
