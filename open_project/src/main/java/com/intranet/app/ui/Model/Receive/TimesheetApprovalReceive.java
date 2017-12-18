package com.intranet.app.ui.Model.Receive;

import java.util.ArrayList;

public class TimesheetApprovalReceive {

    String Status;
    String Status1;

    public String getStatus1() {
        return Status1;
    }

    public void setStatus1(String status1) {
        Status1 = status1;
    }

    String Approver;
    private ArrayList<Staff> Staff = new ArrayList<Staff>();
    private ArrayList<Project> Project = new ArrayList<Project>();


    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getApprover() {
        return Approver;
    }

    public void setApprover(String approver) {
        Approver = approver;
    }

    public ArrayList<Staff> getStaff() {
        return Staff;
    }

    public void setStaff(ArrayList<Staff> staff) {
        Staff = staff;
    }


    public ArrayList<Project> getProject() {
        return Project;
    }

    public void setProject(ArrayList<Project> project) {
        Project = project;
    }

    public TimesheetApprovalReceive(TimesheetApprovalReceive obj) {

        Status = obj.getStatus();
        Approver = obj.getApprover();
        Project = obj.getProject();
        Staff = obj.getStaff();
        Status1 = obj.getStatus1();

    }
}

