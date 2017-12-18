package com.intranet.app.ui.Model.Request;

/**
 * Created by Dell on 11/4/2015.
 */
public class TimesheetstatusRequest {

    /*Local Data Send To Server*/
    String Status;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    /*Initiate Class*/
    public TimesheetstatusRequest() {

    }

    public TimesheetstatusRequest(TimesheetstatusRequest data) {
        Status = data.getStatus();

    }
}