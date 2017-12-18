package com.intranet.app.ui.Model.Receive;

import java.util.ArrayList;

public class TimesheetSearchReceive {

    String Status;
    String Status4;
    String Status1;
    String Status3;
    private ArrayList<TimesheetAppRecord> TimesheetAppRecord = new ArrayList<TimesheetAppRecord>();


    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }





    public String getStatus4() {
        return Status4;
    }

    public void setStatus4(String status4) {
        Status4 = status4;
    }

    public String getStatus1() {
        return Status1;
    }

    public void setStatus1(String status1) {
        Status1 = status1;
    }

    public String getStatus3() {
        return Status3;
    }

    public void setStatus3(String status3) {
        Status3 = status3;
    }

    public ArrayList<TimesheetAppRecord> getTimesheetAppRecord() {
        return TimesheetAppRecord;
    }

    public void setTimesheetAppRecord(ArrayList<TimesheetAppRecord> timesheetAppRecord) {
        TimesheetAppRecord = timesheetAppRecord;
    }

    public TimesheetSearchReceive(TimesheetSearchReceive obj) {

        Status = obj.getStatus();
        Status4 = obj.getStatus4();
        Status1 = obj.getStatus1();
        Status3 = obj.getStatus3();
        TimesheetAppRecord = obj.getTimesheetAppRecord();

    }
}

