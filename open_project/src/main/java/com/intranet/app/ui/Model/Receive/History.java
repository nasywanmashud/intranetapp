package com.intranet.app.ui.Model.Receive;

/**
 * Created by Me-Tech on 9/13/2017.
 */

public class History {

    String Date;
    String ClockIn1;
    String ClockOut1;
    String ClockIn2;
    String ClockOut2;
    String TotalHours;

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getClockIn1() {
        return ClockIn1;
    }

    public void setClockIn1(String clockIn1) {
        ClockIn1 = clockIn1;
    }

    public String getClockOut1() {
        return ClockOut1;
    }

    public void setClockOut1(String clockOut1) {
        ClockOut1 = clockOut1;
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



}