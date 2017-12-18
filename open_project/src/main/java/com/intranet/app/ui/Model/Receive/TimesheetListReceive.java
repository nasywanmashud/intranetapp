package com.intranet.app.ui.Model.Receive;

import java.util.ArrayList;

/**
 * Created by user on 12/4/2017.
 */

public class TimesheetListReceive {

    String Status;
    private ArrayList<TimesheetAppRecord> TimesheetAppRecord = new ArrayList<TimesheetAppRecord>();

    public ArrayList<TimesheetAppRecord> getTimesheetAppRecord() {
        return TimesheetAppRecord;
    }

    public void setTimesheetAppRecord(ArrayList<TimesheetAppRecord> timesheetAppRecord) {
        TimesheetAppRecord = timesheetAppRecord;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public TimesheetListReceive(TimesheetListReceive obj) {

        Status = obj.getStatus();
        TimesheetAppRecord = obj.getTimesheetAppRecord();

    }

}