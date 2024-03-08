package com.example.todolist_servlet;

import java.io.*;
import java.util.ArrayList;

import com.example.todolist_servlet.beans.Status;
import com.example.todolist_servlet.beans.Task;
import com.example.todolist_servlet.service.TaskManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "todo", value = "/todo")
public class ToDoServlet extends HttpServlet {
    TaskManager taskManager = TaskManager.getInstance();

    @Override
    public void init() {
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Task task = new Task()
                .setId(taskManager.getTaskList().size())
                .setName(request.getParameter("name"))
                .setUser(request.getParameter("user"));

        if(task.getErrorMessage().isEmpty()) {
            taskManager.addTask(task);
            this.getServletContext().removeAttribute("errors");
            this.getServletContext().setAttribute("taskList", taskManager.getTaskList());
        } else {
            this.getServletContext().setAttribute("errors", task.getErrorMessage());
        }

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if(request.getParameter("task-start_id") != null) {
            taskManager.updateTaskStatus(Integer.parseInt(request.getParameter("task-start_id")),
                    Status.IN_PROGRESS);
        }
        if(request.getParameter("task-done_id") != null) {
            taskManager.updateTaskStatus(Integer.parseInt(request.getParameter("task-done_id")),
                    Status.DONE);
        }
        if(request.getParameter("task-delete_id") != null) {
            taskManager.deleteTask(Integer.parseInt(request.getParameter("task-delete_id")));
        }
        if(taskManager.getTaskList().isEmpty()) {
            this.getServletContext().removeAttribute("taskList");
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}