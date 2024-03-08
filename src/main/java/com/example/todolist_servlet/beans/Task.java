package com.example.todolist_servlet.beans;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
public class Task {
    private int id;
    private String name;
    private String user;
    private Status status = Status.TODO;
    private final ArrayList<String> errorMessage = new ArrayList<>();

    public Task setId(int id) {
        this.id = id;
        return this;
    }

    public Task setName(String name) {
        if(name.isBlank()){
            errorMessage.add("Nom obligatoire");
        } else {
            this.name = name;
        }
        return this;
    }

    public Task setUser(String user) {
        if(user.isBlank()){
            errorMessage.add("Responsable obligatoire");
        } else {
            this.user = user;
        }
        return this;
    }

    public Task setStatus(Status status) {
        this.status = status;
        return this;
    }
}
