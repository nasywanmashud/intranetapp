package com.intranet.app.ui.Model.Request;

import com.intranet.app.ui.Model.Receive.Project;

/**
 * Created by Dell on 11/4/2015.
 */
public class TimesheetSearchRequest {

    /*Local Data  Send To Server*/
    String Username;
    String Task;
    String Staff;
    String Project;
    String Status;
    String OT;

    public String getProject() {
        return Project;
    }

    public void setProject(String project) {
        Project = project;
    }



    public String getTask() {
        return Task;
    }

    public void setTask(String task) {
        Task = task;
    }

    public String getStaff() {
        return Staff;
    }

    public void setStaff(String staff) {
        Staff = staff;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getOT() {
        return OT;
    }

    public void setOT(String OT) {
        this.OT = OT;
    }



    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }



    /*Initiate Class*/
    public TimesheetSearchRequest() {


    }

    public TimesheetSearchRequest(TimesheetSearchRequest data) {

        Username = data.getUsername();
        Project = data.getProject();
        Task = data.getTask();
        Staff = data.getStaff();
        Status = data.getStatus();
        OT = data.getOT();

    }
}