package com.intranet.app.ui.Model.Receive;

public class TimesheetstatusReceive {

    String Status;
    String Status4;
    String Status1;
    String Status3;

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




    public TimesheetstatusReceive(TimesheetstatusReceive obj) {

        Status = obj.getStatus();
        Status4 = obj.getStatus4();
        Status1 = obj.getStatus1();
        Status3 = obj.getStatus3();


    }
}

