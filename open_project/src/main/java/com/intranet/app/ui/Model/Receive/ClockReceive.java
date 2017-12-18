package com.intranet.app.ui.Model.Receive;

/**
 * Created by Me-Tech on 9/13/2017.
 */

public class ClockReceive {



    String Status ;
    String Date;
    String ClockIn;
    String ClockOut;
    String ClockIn2;
    String ClockOut2;
    String TotalHours;
    String Name;


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        this.Date = date;
    }

    public String getStatus() { return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
    public String getClockIn() {
        return ClockIn;
    }

    public void setClockIn(String clockIn) {
        this.ClockIn = clockIn;
    }

    public String getClockOut() {
        return ClockOut;
    }

    public void setClockOut(String clockOut) {
        this.ClockOut = clockOut;
    }

    public String getClockIn2() {
        return ClockIn2;
    }

    public void setClockIn2(String clockIn2) {
        this.ClockIn2 = clockIn2;
    }

    public String getClockOut2() {
        return ClockOut2;
    }

    public void setClockOut2(String clockOut2) {
        this.ClockOut2 = clockOut2;
    }

    public String getTotalHours() {
        return TotalHours;
    }

    public void setTotalHours(String totalHours) {
        this.TotalHours = totalHours;
    }

    public ClockReceive(ClockReceive returnData) {
        Name = returnData.getName();
        Status = returnData.getStatus();
        Date = returnData.getDate();
        ClockIn = returnData.getClockIn();
        ClockOut = returnData.getClockOut();
        ClockIn2 = returnData.getClockIn2();
        ClockOut2 = returnData.getClockOut2();
        TotalHours = returnData.getTotalHours();
    }

}