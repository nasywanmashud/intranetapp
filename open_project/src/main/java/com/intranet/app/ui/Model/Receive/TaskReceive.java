package com.intranet.app.ui.Model.Receive;

import java.util.ArrayList;

public class TaskReceive {

    String Status;

    public String getStatus1() {
        return Status1;
    }

    public void setStatus1(String status1) {
        Status1 = status1;
    }

    String Status1;

    private ArrayList<Task> Task = new ArrayList<Task>();

    public ArrayList<Task> getTask() {
        return Task;
    }

    public void setTask(ArrayList<Task> task) {
        Task = task;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public TaskReceive(TaskReceive obj) {

        Status = obj.getStatus();
        Task = obj.getTask();
        Status1 = obj.getStatus1();


    }
}

