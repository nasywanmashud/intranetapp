package com.intranet.app.ui.Model.Receive;

import java.util.ArrayList;

public class AttendanceHistoryReceive {

    String Status;
    String StaffId ;
    String Name;
    private ArrayList<History> History = new ArrayList<History>();


    public String getStaffId() {
        return StaffId;
    }

    public void setStaffId(String staffId) {
        StaffId = staffId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }



    public ArrayList<History> getHistory() {
        return History;
    }

    public void setHistory(ArrayList<History> history) {
        History = history;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public AttendanceHistoryReceive(AttendanceHistoryReceive obj) {

        Status = obj.getStatus();
        History = obj.getHistory();
        Name = obj.getName();
        StaffId = obj.getStaffId();
    }
}

