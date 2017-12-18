package com.intranet.app.ui.Model.Receive;


public class Data {

    String Date;
    String Name;
    String ReliefStaff;
    String Status;
    String Type;
    String LeaveType;
    String DayType;
    String Holiday;

    public String getDayType() {
        return DayType;
    }

    public void setDayType(String dayType) {
        DayType = dayType;
    }



    public String getHoliday() {
        return Holiday;
    }

    public String getLeaveType() {
        return LeaveType;
    }

    public void setLeaveType(String leaveType) {
        LeaveType = leaveType;
    }

    public void setHoliday(String holiday) {
        Holiday = holiday;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getReliefStaff() {
        return ReliefStaff;
    }

    public void setReliefStaff(String reliefStaff) {
        ReliefStaff = reliefStaff;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}
